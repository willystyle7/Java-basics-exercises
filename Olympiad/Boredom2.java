package Olympiad;

import java.util.Scanner;

public class Boredom2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());

//  reshava no bavno, polzwa suma na aritmetichna progresia
//        long i = 0;
//        while (number > i * (i+1) / 2) {
//            i++;
//        }
//        System.out.println(i);

        //hitro reshavame kvadratno uravnenie (neravenstvo)
        double root = (Math.sqrt(8 * number + 1) - 1) / 2;
        System.out.printf("%.0f",Math.ceil(root));
    }
}
