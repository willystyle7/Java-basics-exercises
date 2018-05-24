import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.nextLine();
        String second = scan.nextLine();
        String smaller = "";
        String bigger = "";
        boolean broken = false;
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            if (first.charAt(i) < second.charAt(i)) {
                smaller = first;
                bigger = second;
                broken = true;
                break;
            } else if (first.charAt(i) > second.charAt(i)) {
                smaller = second;
                bigger = first;
                broken = true;
                break;
            }
        }
        if (!broken) {
            if (first.length() < second.length()) {
                smaller = first;
                bigger = second;
            } else {
                smaller = second;
                bigger = first;
            }
        }
        System.out.println(String.join("", smaller.split(" ")));
        System.out.println(String.join("", bigger.split(" ")));
    }
}
