import java.io.*;

public class Gamer implements Runnable {
    private GamerHandler gamerHandler;
    private DataInputStream inStream;
    private DataOutputStream outStream;

    Gamer(GamerHandler gamerHandler) {
        this.gamerHandler = gamerHandler;
    }

    public void run() {
        inStream = gamerHandler.getInStream();
        outStream = gamerHandler.getOutStream();
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
    public int getCoordinate() {
        int coordinate = -1;
        try {
            coordinate = inStream.readInt();
        } catch (IOException ex) {
            System.out.println("Ошибка получения сообщения");
        }
        return coordinate;
    }
    public void closeAllStreams() {
        try {
            inStream.close();
            outStream.close();
        } catch (IOException ex) {
            System.out.println("Ошибка закрытия потоков");
        }
    }
}