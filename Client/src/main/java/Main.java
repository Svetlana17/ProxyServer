import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double num1 = 2.0;
        double num2 = 2.0;
        MultiplierProxy proxy = new MultiplierProxy(num1, num2);
        System.out.println("Результат умножения: " + proxy.multiply());
    }
}
