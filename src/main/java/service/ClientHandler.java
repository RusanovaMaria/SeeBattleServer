package service;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private PrintWriter printWriter;
    private Scanner scanner;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        initStreams();
    }

    public void run() {
        while (!clientSocket.isOutputShutdown()) {

        }
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
        printWriter.close();
        scanner.close();
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
}
