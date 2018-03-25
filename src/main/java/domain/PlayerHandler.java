package domain;
import domain.Game.Player.Player;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PlayerHandler implements Runnable {

    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;
    private Player player;

    PlayerHandler(Socket gamerSocket) {
        this.player = player;

        try {
            socket = gamerSocket;
            InputStream inStream = gamerSocket.getInputStream();
            OutputStream outStream = gamerSocket.getOutputStream();
            scanner = new Scanner(inStream);
            writer = new PrintWriter(new OutputStreamWriter(outStream), true);
        } catch (IOException ex) {
            System.out.println("Gamer constructor error");
            ex.printStackTrace();
        }
    }

    public void run() {
        while (!socket.isInputShutdown()) {

        }
    }

    public Scanner getInStream() {
        return scanner;
    }

    public PrintWriter getOutStream() {
        return writer;
    }

    public Socket getSocket() {
        return socket;
    }

    public Player getPlayer() {
        return player;
    }
}