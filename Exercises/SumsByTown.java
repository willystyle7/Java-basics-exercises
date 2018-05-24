import java.util.Scanner;
import java.util.TreeMap;

public class SumsByTown {
    public static void main(String[] args) {
        TreeMap<String, Double> towns = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = scan.nextLine().split("\\s+\\| ");
            String town = inputs[0];
            Double income = Double.parseDouble(inputs[1]);
            if (!towns.containsKey(town)) {
                towns.put(town, income);
            } else {
                towns.replace(town, towns.get(town) + income);
            }
        }
        for (String town : towns.keySet()) {
            System.out.printf("%s -> %s%n", town, towns.get(town));
        }
    }
}

