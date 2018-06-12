package Telerik;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        int columns = 0;
        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            columns = line.length;
            matrix[i] = new int[columns];
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = line[j];
            }
        }
        int[] lineRC = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxSum = 0;
        for (int i = 0; i < lineRC.length / 2; i++) {
            int row = lineRC[i * 2];
            int column = lineRC[i * 2 + 1];
            int currentSum = 0;
            if (row >= 0) {
                for (int k = 0; k <= Math.abs(column) - 1; k++) {
                    currentSum += matrix[row - 1][k];
                }
            } else {
                for (int k = columns - 1; k >= Math.abs(column) - 1; k--) {
                    currentSum += matrix[-row - 1][k];
                }
            }
            if (column >= 0) {
                for (int j = 0; j < Math.abs(row) - 1; j++) {
                    currentSum += matrix[j][column - 1];
                }
            } else {
                for (int j = rows - 1; j > Math.abs(row) - 1; j--) {
                    currentSum += matrix[j][-column - 1];
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);
    }
}
