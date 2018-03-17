import java.io.*;
import java.net.Socket;

public class Gamer implements Runnable {
    private Socket socket;
    DataInputStream inStream;
    DataOutputStream outStream;

    Gamer(Socket gamerSocket) {
        try {
            socket = gamerSocket;
            inStream = new DataInputStream(gamerSocket.getInputStream());
            outStream = new DataOutputStream(gamerSocket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Gamer constructor error");
            ex.printStackTrace();
        }
    }

    public void run() {

    }

    public void sendMessage(String message) {
        try {
            outStream.writeUTF(message);
            outStream.flush();
        } catch (IOException ex) {
            System.out.println("Ошибка правки сообщения");
            ex.printStackTrace();
        }
    }

    public String getMessage() {
        String message = "";
        try {
            message = inStream.readUTF();
        } catch (IOException ex) {
            System.out.println("Ошибка получения сообщения");
        }
        return message;
    }
}