import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String hexNumber = Integer.toHexString(number).toUpperCase();
        String binNumber = Integer.toBinaryString(number);
        System.out.println(hexNumber);
        System.out.println(binNumber);
    }
}
