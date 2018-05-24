import java.util.Scanner;

public class ThreeIntegersSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();

        if (first + second == third) {
            if (first <= second) {
                System.out.printf("%d + %d = %d", first, second, third);
            } else {
                System.out.printf("%d + %d = %d", second, first, third);
            }
        } else if (first + third == second) {
            if (first <= third) {
                System.out.printf("%d + %d = %d", first, third, second);
            } else {
                System.out.printf("%d + %d = %d", third, first, second);
            }
        } else if (second + third == first){
            if (second <= third) {
                System.out.printf("%d + %d = %d", second, third, first);
            } else {
                System.out.printf("%d + %d = %d", third, second, first);
            }
        } else {
            System.out.println("No");
        }
    }
}
