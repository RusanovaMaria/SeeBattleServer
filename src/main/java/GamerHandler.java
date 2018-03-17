import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GamerHandler {

    private Socket socket;
    private DataInputStream inStream;
    private DataOutputStream outStream;

    GamerHandler(Socket gamerSocket) {
        try {
            socket = gamerSocket;
            inStream = new DataInputStream(gamerSocket.getInputStream());
            outStream = new DataOutputStream(gamerSocket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Gamer constructor error");
            ex.printStackTrace();
        }
    }

    public DataInputStream getInStream() {
        return inStream;
    }

    public DataOutputStream getOutStream() {
        return outStream;
    }
}
