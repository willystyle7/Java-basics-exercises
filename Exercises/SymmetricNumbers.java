import java.util.Scanner;

public class SymmetricNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (Integer i = 1; i <= n; i++) {
            if (i.toString().equals(new StringBuffer(i.toString()).reverse().toString())) {
                System.out.printf("%d ", i);
            }
        }
    }
}
