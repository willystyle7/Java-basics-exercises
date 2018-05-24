package Olympiad;

import java.util.Arrays;
import java.util.Scanner;

public class Grading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        long a = (long)Math.ceil(input[0]);
        long b = (long)Math.floor(input[1]);

//        //long sumEven = 0;
//        //long sumOdd = 0;
//        long sum = 0;
//        for (int i = a; i <= b; i++) {
//            if (i % 2 == 0){
//                //sumEven += i;
//                sum += i;
//            } else {
//                //sumOdd += i;
//                sum -= i;
//            }
//        }
//        //long grade = Math.abs(sumOdd - sumEven) % 5 + 2;
//        long grade = Math.abs(sum) % 5 + 2;

        long sum = (b - a + 1) / 2 - ((b - a + 1) % 2) * b;
        long grade = Math.abs(sum) % 5 + 2;
        System.out.println(grade);
    }
}
