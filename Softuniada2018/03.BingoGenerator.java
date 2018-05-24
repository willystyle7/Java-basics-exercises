package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BingoGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int firstTwoDigits = (number / 1000) * 10 + (number / 10) % 10;
        int secondTwoDigits = ((number / 100) % 10) * 10 + number % 10;
        int ceiling = firstTwoDigits + secondTwoDigits;
        List<Integer> divisibleBy12 = new ArrayList<>();
        List<Integer> divisibleBy15 = new ArrayList<>();
        for (int i = firstTwoDigits; i <= ceiling; i++) {
            for (int j = secondTwoDigits; j <= ceiling; j++) {
                int num = i * 100 + j;
                if (num % 12 == 0) {
                    divisibleBy12.add(num);
                }
                if (num % 15 == 0) {
                    divisibleBy15.add(num);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Dividing on 12: ");
        for (Integer num : divisibleBy12) {
            sb.append(num).append(" ");
        }
        sb.append(System.lineSeparator());
        sb.append("Dividing on 15: ");
        for (Integer num : divisibleBy15) {
            sb.append(num).append(" ");
        }
        sb.append(System.lineSeparator());
        if (divisibleBy12.size() == divisibleBy15.size()) {
            sb.append("!!!BINGO!!!");
        } else {
            sb.append("NO BINGO!");
        }
        System.out.println(sb);
    }
}