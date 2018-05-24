package Olympiad;

import java.util.Arrays;
import java.util.Scanner;

public class Palindromes2 {
    public static void main(String[] args) {
        int[] palindromes = {0, 1, 3, 5, 7, 9, 33, 99, 313, 585, 717, 7447, 9009, 15351, 32223, 39993, 53235, 53835, 73737, 585585,
                1758571, 1934391, 1979791, 3129213, 5071705, 5259525, 5841485, 13500531, 719848917, 910373019, 939474939, 1290880921};
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int downLimit = input[0];
        int upLimit = input[1];
        int countPalindromes = 0;
        for (int i = 0; i < palindromes.length; i++) {
            if (palindromes[i] >= downLimit && palindromes[i] <= upLimit) {
                countPalindromes++;
            }
        }
        System.out.println(countPalindromes);
    }
}
