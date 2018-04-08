package service.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler{

    private Socket socket;
    private PrintWriter printWriter;
    private Scanner scannerIn;

    public ClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
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

    public String enterName(){
        sendMessage("Введите свое имя");
        return getMessage();
    }

    public void sendMessage(String message) {
        printWriter.println(message);
    }

    public String getMessage() {

        if (scannerIn.hasNext()) {
          return  scannerIn.nextLine();

        }
       return " ";
    }

    public boolean isExist(){

        if(!socket.isClosed()){
            return true;
        } else return false;
    }

    public void closeAllConnections() {

        try {

            printWriter.close();
            scannerIn.close();
            socket.close();

        } catch (IOException ex){
            System.out.println("Ошибка закрытия соединений");
            ex.printStackTrace();
        }
    }
}
