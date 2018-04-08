package service.server;

import service.gamecontroller.ClassicGameController;
import service.gamecontroller.GameController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ArrayList<ConnectionController> connectionControllers;

    public void go() {

        connectionControllers = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {

                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                ConnectionController connectionController = new ConnectionController(clientHandler);
                connectionControllers.add(connectionController);

                Thread t = new Thread(connectionController);
                t.start();

                ArrayList<ConnectionController> c = findReadyConnectionControllers();
                System.out.println(c.size());

                connectClients();
            }
        } catch (IOException ex) {
            System.out.println("Сбой на стороне сервера");
            ex.printStackTrace();
        }
    }

    private void connectClients() {

        ArrayList<ConnectionController> readyConnectionControllers = findReadyConnectionControllers();

        if (readyConnectionControllers.size() == 2) {
            int greatestEvenNumber = readyConnectionControllers.size() / 2 * 2;

            for (int i = 0; i < greatestEvenNumber; i += 2) {
                ConnectionController firstConnectionController = readyConnectionControllers.get(i);
                ConnectionController secondConnectionController = readyConnectionControllers.get(i + 1);
                ClassicGameController gameController = new ClassicGameController(firstConnectionController, secondConnectionController);
                // gameController.play();

                Thread s = new Thread(gameController);
                s.start();

                firstConnectionController.setState(State.BUSY);
                secondConnectionController.setState(State.BUSY);
            }
        }
    }

    private ArrayList<ConnectionController> findReadyConnectionControllers() {

        ArrayList<ConnectionController> readyConnectionControllers = new ArrayList<>();

        for (int i = 0; i < connectionControllers.size(); i++) {
            ConnectionController connectionController = connectionControllers.get(i);
            if ((connectionControllers.get(i).isReady()) && (connectionControllers.get(i).getState() == State.FREE)) {
                readyConnectionControllers.add(connectionControllers.get(i));
            }
        }
        return readyConnectionControllers;
    }
}

