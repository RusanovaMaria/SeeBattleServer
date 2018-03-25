package service;

import domain.Cell;
import domain.Enums.Result;
import domain.Game.ClassicalGame;
import domain.Game.Game;
import domain.Game.Player.ClassicalPlayer;
import domain.Game.Player.Player;
import domain.PlayerHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {


    private final int PORT = 8989;
    private final String HOST = "127.0.0.1";
    private ArrayList<Player> players;

    public void go() {
        players = new ArrayList<>();
        PlayerHandler gamerHandler;
        Player player;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket gamerSocket = serverSocket.accept();
                gamerHandler = new PlayerHandler(gamerSocket);
                player = new Player() {
                    @Override
                    public String getName() {
                        return null;
                    }

                    @Override
                    public Result action(Cell cell) {
                        return null;
                    }
                };
                players.add(player);

                Thread t = new Thread(gamerHandler);
                t.start();
                System.out.println("got a connection");

                if (players.size() >= 2) {
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
        Player player1 = new ClassicalPlayer(null);
        Player player2 = new ClassicalPlayer(null);

        player1 = players.get(0);
        player2 = players.get(1);
        game = new ClassicalGame(player1, player2);


    }
}