import java.util.Scanner;

public class ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        while (text.contains("<upcase>")) {
            int startIndex = text.indexOf("<upcase>");
            int endIndex = text.indexOf("</upcase>") + 9;
            String toRemove = text.substring(startIndex, endIndex);
            String toInsert = text.substring(startIndex + 8, text.indexOf("</upcase>")).toUpperCase();
            text = text.replace(toRemove, toInsert);
        }
        System.out.println(text);
    }
}
