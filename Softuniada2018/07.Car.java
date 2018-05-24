package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Car {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int[] intervals = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            intervals[i] = Integer.parseInt(tokens[i]);
        }
        int initialSpeed = Integer.parseInt(reader.readLine());
        int maxSpeed = Integer.parseInt(reader.readLine());
        int maxSpeedAchieved = solveDP(intervals, initialSpeed, maxSpeed);
        System.out.println(maxSpeedAchieved);
    }

    private static int solveDP(int[] intervals, int initialSpeed, int maxSpeedAllowed) {
        boolean[][] matrix = new boolean[intervals.length + 1][maxSpeedAllowed + 1];
        matrix[0][initialSpeed] = true;
        for (int row = 1; row < matrix.length; row++) {
            int interval = intervals[row - 1];
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row - 1][col]) {
                    if (col - interval >= 0) {
                        matrix[row][col - interval] = true;
                    }
                    if (col + interval <= maxSpeedAllowed) {
                        matrix[row][col + interval] = true;
                    }
                }
            }
        }
        int bestSum = -1;
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            if (matrix[intervals.length][col]) {
                bestSum = col;
                break;
            }
        }
        return bestSum;
    }
}