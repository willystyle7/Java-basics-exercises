import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputs = scan.nextLine();
        Arrays.stream(inputs.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }
}
