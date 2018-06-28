import java.util.*;

public class ArraySearch {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }

        for (int i = 1; i <= input.length; i++) {
            if (set.contains(i)) {

            } else {
                result.add(i);
            }
        }
        String print = "";
        Iterator<Integer> itr = result.iterator();
        while (itr.hasNext()) {
            print += itr.next() + ",";
        }
        if (print.length() >= 2) {
            print = print.substring(0, print.length() - 1);
        } else {
            print = print.replace(",", "");
        }
        System.out.println(print);
    }
}
