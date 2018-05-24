package Olympiad;

import java.util.Arrays;
import java.util.Scanner;

public class Shoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int skiers = Integer.parseInt(input[0]);
            int shoes = Integer.parseInt(input[1]);
            int[] skiersShoes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] availableShoes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int j = 0; j < skiers; j++) {
                for (int k = 0; k < shoes; k++) {
                    if (skiersShoes[j] <= availableShoes[k]){
                        count++;
                        availableShoes[k] = 0;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
