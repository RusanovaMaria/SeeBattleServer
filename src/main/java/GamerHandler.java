import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GamerHandler implements Runnable {

    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;

    GamerHandler(Socket gamerSocket) {
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
}

