package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Asteroids {

    private static int[][] matrix;
    private static int size;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!"end".equals(input = reader.readLine())) {
            String[] tokens = input.split("x");
            int rows = Integer.parseInt(tokens[0]);
            int cols = Integer.parseInt(tokens[1]);
            matrix = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                String line = reader.readLine();
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = line.charAt(col) == '1' ? 1 : 0;
                }
            }
            Map<Integer, Integer> asteroids = new TreeMap<>(Comparator.reverseOrder());
            int totalFound = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == 1) {
                        size = 0;
                        DFS(row, col);
                        asteroids.putIfAbsent(size, 0);
                        asteroids.put(size, asteroids.get(size) + 1);
                        totalFound++;
                    }
                }
            }
            for (Map.Entry<Integer, Integer> pair : asteroids.entrySet()) {
                sb.append(pair.getValue()).append("x").append(pair.getKey()).append(System.lineSeparator());
            }
            sb.append("Total: ").append(totalFound).append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    private static void DFS(int row, int col) {
        if (!isInBounds(row, col) || matrix[row][col] != 1) {
            return;
        }
        if (matrix[row][col] == 1) {
            size++;
        }
        matrix[row][col] = -1;
        DFS(row - 1, col);
        DFS(row, col - 1);
        DFS(row + 1, col);
        DFS(row, col + 1);
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}