package Olympiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ninja {
    public static void main(String[] args) throws IOException {
        BufferedReader bInput = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bInput.readLine());
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(bInput.readLine());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] line = Arrays.stream(bInput.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = line[j];
                }
            }
            matrix[0][0] = 0;
            ArrayList<Integer> times = new ArrayList<Integer>();
            Queue<ReachedCell> queue = new LinkedList<ReachedCell>();
            ReachedCell startCell = new ReachedCell();
            startCell.setRow(0);
            startCell.setCol(0);
            startCell.setTime(1);
            queue.add(startCell);
            while (queue.size() > 0) {
                ReachedCell currentCell = queue.remove();
                int row = currentCell.getRow();
                int col = currentCell.getCol();
                int time = currentCell.getTime();
                if (row == n - 1 && col == n - 1) {
                    times.add(time);
                    continue;
                }
                time++;
                if (row + 1 < n) {
                    if (matrix[row + 1][col] ==1)
                    {
                        time++;
                    }
                    ReachedCell DownCell = new ReachedCell();
                    DownCell.setRow(row + 1);
                    DownCell.setCol(col);
                    DownCell.setTime(time);
                    queue.add(DownCell);
                }
                if (col + 1 < n) {
                    if (matrix[row][col + 1] ==1)
                    {
                        time++;
                    }
                    ReachedCell RightCell = new ReachedCell();
                    RightCell.setRow(row);
                    RightCell.setCol(col + 1);
                    RightCell.setTime(time);
                    queue.add(RightCell);
                }
            }
            int minimum = times.stream().mapToInt(p -> p).min().getAsInt();
            minimum--;
            System.out.println(minimum);
        }
    }
}


class ReachedCell {

    public int Row;

    public int Col;

    public int Time;

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int col) {
        Col = col;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }
}