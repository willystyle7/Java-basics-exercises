import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String result = new StringBuffer(str).reverse().toString();
        System.out.println(result);
    }
}
