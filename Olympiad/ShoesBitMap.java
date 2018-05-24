package Olympiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShoesBitMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bInput = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bInput.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = bInput.readLine().split("\\s+");
            int skiers = Integer.parseInt(input[0]);
            int shoes = Integer.parseInt(input[1]);
            String[] skiersShoes = bInput.readLine().split("\\s+");
            String[] availableShoes =  bInput.readLine().split("\\s+");
            int count = 0;
            int[] availableShoesBySize = new int[50];
            int[] skiersShoesBySize = new int[50];
            for (String shoe : skiersShoes) {
                skiersShoesBySize[Integer.parseInt(shoe)]++;
            }
            for (String shoe : availableShoes) {
                availableShoesBySize[Integer.parseInt(shoe)]++;
            }
            for (int j = 49; j >= 20; j--) {
                if (skiersShoesBySize[j] <= availableShoesBySize[j]) {
                    count += skiersShoesBySize[j];
                    availableShoesBySize[j] -= skiersShoesBySize[j];
                    skiersShoesBySize[j] = 0;
                } else {
                    count += availableShoesBySize[j];
                    skiersShoesBySize[j] -= availableShoesBySize[j];
                    availableShoesBySize[j] = 0;
                    int k = j + 1;
                    while (skiersShoesBySize[j] > 0 && k <= 49) {
                        if (skiersShoesBySize[j] <= availableShoesBySize[k]) {
                            count += skiersShoesBySize[j];
                            availableShoesBySize[k] -= skiersShoesBySize[j];
                            skiersShoesBySize[j] = 0;
                            continue;
                        } else {
                            count += availableShoesBySize[k];
                            skiersShoesBySize[j] -= availableShoesBySize[k];
                            availableShoesBySize[k] = 0;
                        }
                        k++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
