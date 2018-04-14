import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxLen = 0; //actually length of sequence - 1 in here
        int len = 0;
        int startIndex = 0;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                len += 1;
                if (i == nums.length - 2) {
                    if (len > maxLen) {
                        maxLen = len;
                        startIndex = index;
                    }
                }
            } else {
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = index;
                }
                len = 0;
                index = i + 1;
            }
        }
        for (int i = startIndex; i < startIndex + maxLen + 1; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }
}
