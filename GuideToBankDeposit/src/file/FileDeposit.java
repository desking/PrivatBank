package file;



import deposit.Deposit;

import java.io.*;
import java.util.ArrayList;

public class FileDeposit {

    public void addToFile(ArrayList<Deposit> deposits) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("deposits.dat"))) {

            out.writeObject(deposits);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Deposit> readFromFile() {
        ArrayList<Deposit> deposits =new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("deposits.dat"))) {
            deposits = (ArrayList<Deposit>) in.readObject();
            return deposits;
        }
        catch (EOFException e){
            return deposits;
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
