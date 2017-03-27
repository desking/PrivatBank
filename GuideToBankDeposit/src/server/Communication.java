package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class Communication {
    public Communication() {
        try {
            ServerSocket server = null;
            client = null;
            try {
                server = new ServerSocket(3456);
                System.out.println("Жду клиентов...");


                while(true) {
                    client = server.accept();

                    System.out.println("Клиент подключен!!!");

                    Runnable r = new ThreadHandler(client);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
            finally {
                client.close();
                server.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Socket client;

}
