import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class MultiplierProxy {
    int port = 5000;
    private double num1, num2;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public MultiplierProxy(double num1, double num2) throws IOException {
        this.num1 = num1;
        this.num2 = num2;
        socket = new Socket(InetAddress.getLocalHost(), port);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public double multiply() throws IOException {
        dataOutputStream.writeDouble(num1);
        dataOutputStream.writeDouble(num2);
        double result = dataInputStream.readDouble();
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        return result;
    }
}
