package Telerik;

import java.util.Scanner;

public class SendMeTheCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = Integer.toString(Math.abs(scan.nextInt()));
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            int index = number.length() - i;
            int digit = number.charAt(i) - '0';
            if (index % 2 == 0) {
                result += digit * digit * index;
            } else {
                result += digit * index * index;
            }
        }
        int lengthMessage = result % 10;
        int startMessage = result % 26 + 1;
        if (lengthMessage == 0) {
            System.out.println(result);
            System.out.println("Big Vik wins again!");
        } else {
            String resultMessage = "";
            int indexMessage = startMessage;
            for (int i = 1; i <= lengthMessage; i++) {
                resultMessage += (char) (64 + indexMessage);
                indexMessage = indexMessage % 26 + 1;
            }
            System.out.println(result);
            System.out.println(resultMessage);
        }
    }
}
