import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.length() < 20) {
            str = padRight(str, '*');
        } else {
            str = str.substring(0, 20);
        }
        System.out.println(str);
    }

    private static String padRight(String str, char c) {
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < 20) {
            sb.append(c);
        }
        return sb.toString();
    }
}
