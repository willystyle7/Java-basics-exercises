package Olympiad;

import java.util.Scanner;

public class Boredom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        long member = 0;
        long count = 0;
        long i = 1;
        while (true) {
            boolean find = false;
            for (long j = 1; j <= i; j++) {
                count++;
                if (count == number){
                    member = i;
                    find = true;
                    break;
                }
            }
            if (find) break;
            i++;
        }
        System.out.println(member);
    }
}
