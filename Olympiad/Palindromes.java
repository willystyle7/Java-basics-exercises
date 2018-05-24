package Olympiad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int downLimit = input[0];
        int upLimit = input[1];
        int countPalindromes = 0;
        for (int i = downLimit; i <= upLimit; i++) {
            //String strNumber = Integer.toString(i);
            //String strNumber = i + "";
            //String strNumber = String.valueOf(i);
            if (isPalindrome(i)) {
                String binNumber = Integer.toBinaryString(i);
                if (IsPalindrome(binNumber)) {
                    countPalindromes++;
                }
            }
        }
        System.out.println(countPalindromes);
    }

    public static String ReverseStr(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return reversedStr;
    }

    public static boolean IsPalindrome(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        for (int i = 0; i < digits.size()/2; i++) {
            if (digits.get(i) != digits.get(digits.size() - 1 - i)){
                return false;
            }
        }
        return true;
        //return IntStream.range(0, digits.size() / 2).allMatch( index -> digits.get(index) == digits.get(digits.size() - 1 - index));
    }
}
