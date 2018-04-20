package service;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {

    private Socket socket;
    private PrintWriter printWriter;
    private Scanner scannerIn;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        initStreams();
    }

    private void initStreams() {
        try {
            InputStream inputStream = socket.getInputStream();
            scannerIn = new Scanner(inputStream, "UTF-8");
            OutputStream outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream), true);

        } catch (IOException ex) {
            System.out.println("Ошибка в потоке");
            ex.printStackTrace();
        }
    }

    private void read() {

        while (scannerIn.hasNext()) {

        }
    }
}
