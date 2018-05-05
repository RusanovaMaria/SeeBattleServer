package service;

import application.client.Client;
import application.client.ClientSet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 5000;

    private ClientSet clientSet = new ClientSet();

    private Server() {}

    public void go() {

        try{

            ServerSocket serverSocket = new ServerSocket(PORT);

                while(true) {

                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    Client client = new Client(clientHandler);
                    clientSet.add(client);

                    Thread thread = new Thread(clientHandler);
                    thread.start();
                }
        } catch (IOException ex) {

            System.out.println("Ошибка на стороне сервера");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Server server = new Server();

        server.go();
    }
}
