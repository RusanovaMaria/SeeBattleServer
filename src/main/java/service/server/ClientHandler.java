package service.server;

import domain.player.Player;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private PrintWriter printWriter;
    private Scanner scanner;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        initStreams();
    }

    private void initStreams() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            scanner = new Scanner(inputStream, "UTF-8");
            OutputStream outputStream = clientSocket.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream), true);

        } catch (IOException ex) {
            System.out.println("Ошибка в потоке");
            ex.printStackTrace();
        }
    }

    public String enterName() {
        String name = null;

        requestName();
        name = readName();

        return name;
    }

    private void requestName() {
        sendMessage("Введите ваш ник");
    }

    private String readName() {
        return getMessage();
    }

    public String getMessage() {
        String message = "";

        if (scanner.hasNext()) {
            message = scanner.nextLine();

        }
        return message;
    }

    public void sendMessage(String message) {
        printWriter.println(message);
    }

    public void closeAllConnections() {

        try {
            printWriter.close();
            scanner.close();
            clientSocket.close();

        } catch (IOException ex) {
            System.out.println("Ошибка закрытия сокета");
            ex.printStackTrace();
        }
    }

    public void run() {

        ConnectionController connectionController = new ConnectionController(this);

        while (!clientSocket.isClosed()) {

        }
    }
}
