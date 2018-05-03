package service;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

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

    @Override
    public void run() {

        while (!socket.isClosed()) {

            readAllTraffic();
        }
    }

    private void readAllTraffic() {

        if(scannerIn.hasNext()) {

            String command = scannerIn.nextLine();

            CommandController commandController = new CommandController(this);
            commandController.handle(command);
        }
    }

    public void write(String message) {

        printWriter.println(message);
    }

    public String read() {

        String message = "";

        if (scannerIn.hasNext()) {
            message = scannerIn.nextLine();
        }

        return message;
    }
}
