import java.util.Scanner;

public class ReverseCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] letters = new String[3];
        for (int i = 0; i < 3; i++) {
            String letter = scan.nextLine();
            letters[i] = letter;
        }
        for (int i = 2; i >=0 ; i--) {
            System.out.print(letters[i]);
        }
        System.out.println();
    }
}
