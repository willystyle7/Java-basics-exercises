import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.2f", a + b);
    }
}
