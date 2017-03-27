package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 3456);
            try {
                //Создаем выходной поток клиента
                OutputStream outStream = client.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);

                System.out.print("Введите команду: ");
                Scanner in = new Scanner(System.in);
                String сommand = in.nextLine();


                out.println(сommand);

//Создаем входной поток клиента
                InputStream inStream = client.getInputStream();
                BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
                String c = inputLine.readLine();
                while (c != null) {
                    System.out.println(c);
                    c = inputLine.readLine();
                }

            } finally {
                client.close();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}