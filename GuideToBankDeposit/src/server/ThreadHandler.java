package server;

import java.io.*;
import java.net.Socket;


class ThreadHandler implements Runnable {
    private Socket client;
    DepositControl depositControl = new DepositControl();

    public ThreadHandler(Socket st) {
        client = st;
    }

    public void run() {
        try {
            //Создаем входной поток сервера
            InputStream inStream = client.getInputStream();
            BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
            String stringFromClient = inputLine.readLine(); //Строка, полученная от клиента

            System.out.println(stringFromClient);

            String[] strSep = null;
            String command;

            //Парсим строку, чтобы получить команду и даные

            if (stringFromClient.contains("<")) {
                command = stringFromClient.substring(0, stringFromClient.indexOf('<') - 1);
                String afterCommand = stringFromClient.substring(stringFromClient.indexOf('<') + 1, stringFromClient.length());
                strSep = afterCommand.split("[\\s,<>]+");
            } else {

                command = stringFromClient.trim();
            }


//Создаем выходной поток сервера
            OutputStream outStream = client.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true);

            switch (command) {
                case "add":
                    out.println(depositControl.add(strSep));
                    break;
                case "list":
                    out.println(depositControl.list());
                    break;
                case "sum":
                    out.println(depositControl.sum());
                    break;
                case "count":
                    out.println(depositControl.count());
                    break;
                case "delete":
                    int accountId = Integer.parseInt(strSep[0]);
                    out.println(depositControl.delete(accountId));
                    break;
                case "show type":
                    String type = strSep[0];
                    out.println(depositControl.showType(type));
                    break;
                case "show bank":
                    String name = strSep[0];
                    out.println(depositControl.showBank(name));
                    break;
                case "info account":
                    int Id = Integer.parseInt(strSep[0]);
                    out.println(depositControl.infoAccount(Id));
                    break;
                case "info depositor":
                    String depositor = strSep[0];
                    out.println(depositControl.infoDepositor(depositor));
                    break;


            }

            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
