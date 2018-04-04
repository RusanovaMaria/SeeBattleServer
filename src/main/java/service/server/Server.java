package service.server;

import domain.player.Player;
import service.gamecontroller.ClassicGameController;
import service.gamecontroller.GameController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private ArrayList<ConnectionController> connectionControllers = new ArrayList<>();

    public void go() {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread t = new Thread(clientHandler);
                t.start();

                connectClients();

            }
        } catch (IOException ex) {
            System.out.println("Сбой на стороне сервера");
            ex.printStackTrace();
        }
    }

    private void connectClients(){
        if (connectionControllers.size() == 2){
            ConnectionController firstConnectionController = connectionControllers.get(0);
            ConnectionController secondConnectionController = connectionControllers.get(1);

            GameController gameController = new ClassicGameController(firstConnectionController, secondConnectionController);
            gameController.play();
        }
    }
}
