package server;

import deposit.Deposit;
import file.FileDeposit;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class DepositControl implements CommandsForServer {


    DepositControl() {
        if (new File("deposits.dat").exists()) {
            FileDeposit binaryFile = new FileDeposit();
            deposits = binaryFile.readFromFile();
        }
    }

    private ArrayList<Deposit> deposits = new ArrayList<>();

    private void addDepositToFile(ArrayList<Deposit> deposits) {
        FileDeposit file = new FileDeposit();
        file.addToFile(deposits);
    }
    @Override
    public String list() {
        String listDeposits = "";
        if (deposits.isEmpty()){
            return "Пусто!!!";
        }
        for (Deposit deposit : deposits) {
            listDeposits += deposit.toString() + "\n";
        }
        return listDeposits;
    }

    @Override
    public double sum() {
        double sumDeposit = 0;
        for (Deposit deposit : deposits) {
            sumDeposit += deposit.getAmountOnDeposit();
        }
        return sumDeposit;
    }

    @Override
    public int count() {
        return deposits.size();
    }

    @Override
    public String infoAccount(int accountId) {
        String infoAccount = "";
        for (Deposit deposit : deposits) {
            if (deposit.getAccountId() == accountId) {
                infoAccount = deposit.toString();
                break;
            }
        }
        return infoAccount;
    }

    @Override
    public String infoDepositor(String depositor) {
        String listDepositor = "";
        for (Deposit deposit : deposits) {
            if (deposit.getDepositor().equals(depositor)) {
                listDepositor += deposit.toString() + "\n";
            }
        }
        return listDepositor;
    }

    @Override
    public String showType(String type) {
        String listDeposits = "";
        for (Deposit deposit : deposits) {
            if (deposit.getType().equals(type)) {
                listDeposits += deposit.toString() + "\n";
            }
        }
        return listDeposits;
    }

    @Override
    public String showBank(String name) {
        String listDeposits = "";
        for (Deposit deposit : deposits) {
            if (deposit.getName().equals(name)) {
                listDeposits += deposit.toString() + "\n";
            }
        }
        return listDeposits;
    }

    @Override
    public String add(String[] strSep) {
        String name = strSep[0];
        String country = strSep[1];
        String type = strSep[2];
        String depositor = strSep[3];
        int accountId = Integer.parseInt(strSep[4]);
        double amountOnDeposit = Double.parseDouble(strSep[5]);
        double profitability = Double.parseDouble(strSep[6]);
        double timeConstraints = Double.parseDouble(strSep[7]);

        if (amountOnDeposit > 0 && profitability > 0 && timeConstraints > 0) {
            for (Deposit dep : deposits) {
                if (dep.getAccountId() == accountId) {

                    return "Ошибка!!!";
                }
            }
            deposits.add(new Deposit(name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints));
            addDepositToFile(deposits);
            return "ОК";
        }

        return "Ошибка!!!";
    }

    @Override
    public String delete(int accountId) {
        Iterator<Deposit> depositIterator = deposits.iterator();
        while (depositIterator.hasNext()) {
            if (depositIterator.next().getAccountId() == accountId) {
                depositIterator.remove();
                addDepositToFile(deposits);
                return "Вкладчик удален!!!";
            }
        }
        return "Вкладчик не найден!!!";
    }
}
