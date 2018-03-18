import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private final int PORT = 8989;
    private final String HOST = "127.0.0.1";
    private ArrayList<Gamer> gamers;

    public void go() {
        gamers = new ArrayList<>();
        GamerHandler gamerHandler;
        Gamer gamer;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket gamerSocket = serverSocket.accept();
                gamerHandler = new GamerHandler(gamerSocket);
                gamer = new Gamer(gamerHandler);
                gamers.add(gamer);

                Thread t = new Thread(gamerHandler);
                t.start();
                System.out.println("got a connection");

                if (gamers.size() >= 2) {
                    connectGamers();
                }
            }
        } catch (IOException ex) {
            System.out.println("Go method error");
            ex.printStackTrace();
        }
    }

    private void connectGamers() {
        Game game;
        Gamer gamer1;
        Gamer gamer2;

        gamer1 = gamers.get(0);
        gamer2 = gamers.get(1);
        game = new Game(gamer1, gamer2);
        game.play();
    }
}


    