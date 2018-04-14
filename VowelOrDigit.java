import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if (Character.isDigit(c)) {
            System.out.println("digit");
        } else if (c == 'a' || c == 'o' || c == 'i' ||
                c == 'e' || c == 'u') {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}
