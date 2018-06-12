using System;
using System.Linq;

class MatrixMaxSum
{
    static void Main()
    {
        int rows = int.Parse(Console.ReadLine());
        int[][] matrix = new int[rows][];
        int columns = 0;
        for (int i = 0; i < rows; i++)
        {
            int[] line = Console.ReadLine().Split().Select(int.Parse).ToArray();
            columns = line.Length;
            matrix[i] = new int[columns];
            for (int j = 0; j < columns; j++)
            {
                matrix[i][j] = line[j];
            }
        }
        int[] lineRC = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int maxSum = 0;
        for (int i = 0; i < lineRC.Length / 2; i++)
        {
            int row = lineRC[i * 2];
            int column = lineRC[i * 2 + 1];
            int currentSum = 0;
            if (row >= 0)
            {
                for (int k = 0; k <= Math.Abs(column) - 1; k++)
                {
                    currentSum += matrix[row - 1][k];
                }
            }
            else
            {
                for (int k = columns - 1; k >= Math.Abs(column) - 1; k--)
                {
                    currentSum += matrix[-row - 1][k];
                }
            }
            if (column >= 0)
            {
                for (int j = 0; j < Math.Abs(row) - 1; j++)
                {
                    currentSum += matrix[j][column - 1];
                }
            }
            else
            {
                for (int j = rows - 1; j > Math.Abs(row) - 1; j--)
                {
                    currentSum += matrix[j][-column - 1];
                }
            }
            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }
        }
        Console.WriteLine(maxSum);
    }
}

