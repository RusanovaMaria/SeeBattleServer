package service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 5000;

    private Server() {}

    private ClientSet clientSet = new ClientSet();

    public void go() {

        try{

            ServerSocket serverSocket = new ServerSocket(PORT);

                while(true) {

                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    Client client = new Client(clientHandler);
                    clientSet.add(client);
                }
        } catch (IOException ex) {

            System.out.println("Ошибка на стороне сервера");
            ex.printStackTrace();
        }
    }
}
