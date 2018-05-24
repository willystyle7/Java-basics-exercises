package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WrongResults {

    private static int[][][] cube;
    private static boolean[][][] isWrong;
    private static int wrongNumbersCount;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        initializeCube(reader);
        String[] tokens = reader.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        int z = Integer.parseInt(tokens[2]);
        int wrongNum = cube[x][y][z];
        initializeBoolMatrix(wrongNum);
        correctMatrix(wrongNum);
        printOutput();
    }

    private static void printOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wrong values found and replaced: ").append(wrongNumbersCount);
        sb.append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(cube[i][j][k]).append(" ");
                }
                sb.append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }

    private static void correctMatrix(int wrongNum) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (cube[j][i][k] == wrongNum) {
                        int sum = 0;
                        if (isInBounds(j, i, k - 1) && !isWrong[j][i][k - 1]) {
                            sum += cube[j][i][k - 1];
                        }
                        if (isInBounds(j, i - 1, k) && !isWrong[j][i - 1][k]) {
                            sum += cube[j][i - 1][k];
                        }
                        if (isInBounds(j - 1, i, k) && !isWrong[j - 1][i][k]) {
                            sum += cube[j - 1][i][k];
                        }
                        if (isInBounds(j, i, k + 1) && !isWrong[j][i][k + 1]) {
                            sum += cube[j][i][k + 1];
                        }
                        if (isInBounds(j, i + 1, k) && !isWrong[j][i + 1][k]) {
                            sum += cube[j][i + 1][k];
                        }
                        if (isInBounds(j + 1, i, k) && !isWrong[j + 1][i][k]) {
                            sum += cube[j + 1][i][k];
                        }
                        cube[j][i][k] = sum;
                    }
                }
            }
        }
    }

    private static void initializeBoolMatrix(int wrongNum) {
        isWrong = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (cube[j][i][k] == wrongNum) {
                        isWrong[j][i][k] = true;
                        wrongNumbersCount++;
                    }
                }
            }
        }
    }

    private static void initializeCube(BufferedReader reader) throws IOException {
        cube = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" \\| ");
            for (int j = 0; j < n; j++) {
                String[] tokens = line[j].split(" ");
                for (int k = 0; k < n; k++) {
                    cube[j][i][k] = Integer.parseInt(tokens[k]);
                }
            }
        }
    }

    private static boolean isInBounds(int j, int i, int k) {
        return j >= 0 && j < n && i >= 0 && i < n && k >= 0 && k < n;
    }
}