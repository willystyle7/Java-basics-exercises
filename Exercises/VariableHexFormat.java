import java.util.Scanner;

public class VariableHexFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexNumber = scanner.nextLine();
        //int decNumber = scanner.nextInt(16);
        int decNumber = Integer.parseInt(hexNumber, 16);
        System.out.println(decNumber);
    }
}
