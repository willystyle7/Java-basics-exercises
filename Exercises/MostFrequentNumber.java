import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxCount = 0;
        int count = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                result = nums[i];
            }
            count = 0;
        }
        System.out.println(result);
    }
}
