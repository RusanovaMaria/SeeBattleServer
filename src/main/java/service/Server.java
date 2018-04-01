package service;

import application.ClassicGameImplementation;
import application.GameImplementation;
import domain.player.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class Server {

    private ArrayList<ConnectionAdapter> connectionAdapters;

    public void go() {

        connectionAdapters = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                ConnectionAdapter connectionAdapter = new ConnectionAdapter(clientHandler);
                connectionAdapters.add(connectionAdapter);

                Thread t = new Thread(clientHandler);
                t.start();

                start();
            }

        } catch (IOException ex) {
            System.out.println("Сбой на стороне сервера");
            ex.printStackTrace();
        }
    }

    private void start(){
        if (connectionAdapters.size() == 2) {
            ConnectionAdapter firstConnectionAdapter = connectionAdapters.get(0);
            ConnectionAdapter secondConnectionAdapter = connectionAdapters.get(1);
            GameImplementation gameImplementation = new ClassicGameImplementation(firstConnectionAdapter, secondConnectionAdapter);
            gameImplementation.play();
        }
    }
}
