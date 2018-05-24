import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BombNumers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            nums.add(input[i]);
        }
        String inputs = scan.nextLine();
        int bomb = Integer.parseInt(inputs.substring(0, 1));
        int power = Integer.parseInt(inputs.substring(2, 3));
        while (nums.contains(bomb)){
            int bombIndex = nums.indexOf(bomb);
            int leftCount = Math.min(power, bombIndex);
            int rightCount = Math.min(power, nums.size() - 1 - bombIndex);
            for (int i = 0; i < leftCount + rightCount + 1; i++) {
                nums.remove(bombIndex - leftCount);
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        System.out.println(sum);
    }
}
