import java.util.Scanner;
        import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, String> names = new TreeMap<>();
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
            } else if (inputs.length == 2){
                String name = inputs[1];
                if (names.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, names.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            } else {
                for (String key : names.keySet()) {
                    System.out.printf("%s -> %s%n", key, names.get(key));
                }
            }
            input = scan.nextLine();
        }
    }
}
