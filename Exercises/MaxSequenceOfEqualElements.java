import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxLen = 0;
        int num = nums[0];
        int len = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                len += 1;
                if (i == nums.length-2) {
                    if (len > maxLen) {
                        maxLen = len;
                        num = nums[i];
                    }
                }
            } else {
                if (len > maxLen) {
                    maxLen = len;
                    num = nums[i];
                }
                len = 0;
            }
        }
        for (int i = 0; i <= maxLen; i++) {
            System.out.printf("%d ", num);
        }
    }
}
