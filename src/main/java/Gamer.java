import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gamer implements Runnable{
    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;

    Gamer (Socket gamerSocket) {
        try {
            socket = gamerSocket;
            InputStream inStream = gamerSocket.getInputStream();
            OutputStream outStream = gamerSocket.getOutputStream();

            scanner = new Scanner(inStream, "Cp1251");
            writer = new PrintWriter(new OutputStreamWriter(outStream, "Cp1251"),true);

        } catch (IOException ex){
            System.out.println("Gamer constructor error");
            ex.printStackTrace();
        }
    }
    public void run() {

    }

    public PrintWriter getPrintWriter(){
        return writer;
    }

    public Scanner gerScanner(){
        return scanner;
    }
}