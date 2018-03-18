import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Gamer{
    private GamerHandler gamerHandler;
    private Scanner scanner;
    private PrintWriter writer;
    private Socket socket;

    Gamer(GamerHandler gamerHandler) {
        this.gamerHandler = gamerHandler;
        scanner = gamerHandler.getInStream();
        writer = gamerHandler.getOutStream();
        socket = gamerHandler.getSocket();
    }

    public void sendMessage(String message) {
            writer.println(message);

    }
    public int getCoordinate() {
        int coordinate = -1;
            if (scanner.hasNext()) {
                coordinate = scanner.nextInt();
            }
        return coordinate;
    }
    public void finish() {
        try {
            scanner.close();
            writer.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Ошибка закрытия потоков");
        }
    }
}