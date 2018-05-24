import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> names = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] inputs = input.split(" ");
            if (inputs.length == 3) {
                String name = inputs[1];
                String number = inputs[2];
                if (!names.containsKey(name)) {
                    names.put(name, number);
                } else {
                    names.replace(name, number);
                }
            } else {
                String name = inputs[1];
                if (names.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, names.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            }
            input = scan.nextLine();
        }
    }
}
