import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream= new DataOutputStream(socket.getOutputStream());
            double num1= dataInputStream.readDouble();
            double num2 = dataInputStream.readDouble();
            System.out.println("Получены числа: " + num1 + " и " + num2);
            dataOutputStream.writeDouble(num1 * num2);
            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}

