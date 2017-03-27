package server;

public interface CommandsForServer {

    String list();

    double sum();

    int count();

    String infoAccount(int accountId);

    String infoDepositor(String depositor);

    String showType(String type);

    String showBank(String name);

    String add(String[] strSep);

    String delete(int accountId);
}
