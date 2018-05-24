package Olympiad;

import java.math.BigDecimal;
import java.util.Scanner;

public class Digit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        BigDecimal result = new BigDecimal(number);
        result = result.pow(number);
        String resultStr = String.valueOf(result);
        char digit = (resultStr.length() <= (number - 1)) ? '*' : resultStr.charAt(number - 1);
        System.out.println(digit);
    }
}
