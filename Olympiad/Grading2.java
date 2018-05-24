package Olympiad;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Grading2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        long a = Long.parseLong(input[0].split("\\.")[0]);
        long b = Long.parseLong(input[1].split("\\.")[0]);
        long sum = (b - a + 1) / 2 - ((b - a + 1) % 2) * b;
        long grade = Math.abs(sum) % 5 + 2;

//        BigInteger a = new BigInteger(input[0]);
//        BigInteger b = new BigInteger(input[1]);
//        BigInteger temp = (((b.subtract(a)).add(BigInteger.valueOf(1))).remainder(BigInteger.valueOf(2))).multiply(b);
//        BigInteger sum =  (((b.subtract(a)).add(BigInteger.valueOf(1))).mod(BigInteger.valueOf(2))).subtract(temp);
//        BigInteger grade = ((sum.abs()).remainder(BigInteger.valueOf(5))).add(BigInteger.valueOf(2));

        System.out.println(grade);
    }
}
