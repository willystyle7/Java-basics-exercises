package Olympiad;

import java.math.BigDecimal;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        //long sum = 0;
        BigDecimal sum = new BigDecimal(0);
        String numberStr = String.valueOf(number);
        int n = numberStr.length();
        for (int i = 0; i < Math.pow(2, n); i++) {
            String mask = Integer.toBinaryString(i);
            StringBuilder maskSb = new StringBuilder(mask);
            //padding left with 0
            while (maskSb.length() < n){
                maskSb.insert(0, '0');
            }
            //generating masked number
            boolean dontSum = false;
            for (int j = 0; j < n; j++) {
                if (numberStr.charAt(j) == '0' && maskSb.charAt(j)== '0'){
                    dontSum = true;
                }
                maskSb.setCharAt(j, (char)((maskSb.charAt(j) - '0')*(numberStr.charAt(j) - '0') + '0'));
            }
            if (!dontSum){
                //sum += Long.parseLong(maskSb.toString());
                sum = sum.add(BigDecimal.valueOf(Long.parseLong(maskSb.toString())));
            }
        }
        System.out.println(sum);
    }
}
