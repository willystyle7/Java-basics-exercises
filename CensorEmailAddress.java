import java.util.Scanner;

public class CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String text = scan.nextLine();
        String username = email.substring(0, email.indexOf('@'));
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < username.length(); i++) {
            masked.append('*');
        }
        String fixed = masked.toString() + email.substring(email.indexOf('@'));
        text = text.replace(email, fixed);
        System.out.println(text);
    }
}
