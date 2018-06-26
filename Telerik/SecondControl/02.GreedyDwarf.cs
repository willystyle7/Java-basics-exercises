using System;
using System.Linq;

class GreedyDwarf
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split();
        int rows = int.Parse(input[0]);
        int columns = int.Parse(input[1]);
        int[,] labyrinth = new int[rows, columns];
        int positionRow = 0;
        int positionColumn = 0;
        for (int i = 0; i < rows; i++)
        {
            int[] token = Console.ReadLine().Split().Select(int.Parse).ToArray();
            for (int j = 0; j < columns; j++)
            {
                labyrinth[i, j] = token[j];
                if (labyrinth[i, j] == 0)
                {
                    positionRow = i;
                    positionColumn = j;
                }
            }
        }
        int coins = 0;
        bool move = true;
        while (move)
        {
            int left = positionColumn - 1 >= 0 ? labyrinth[positionRow, positionColumn - 1] : 0;
            int right = positionColumn + 1 < columns ? labyrinth[positionRow, positionColumn + 1] : 0;
            int up = positionRow - 1 >= 0 ? labyrinth[positionRow - 1, positionColumn] : 0;
            int down = positionRow + 1 < rows ? labyrinth[positionRow + 1, positionColumn] : 0;

            if (left > 0 && left >= right && left >= up && left >= down)
            {
                positionColumn--;
            }
            else if (right > 0 && right >= up && right >= down)
            {
                positionColumn++;
            }
            else if (up > 0 && up >= down)
            {
                positionRow--;
            }
            else if (down > 0)
            {
                positionRow++;
            }
            else
            {
                move = false;
                continue;
            }
            coins++;
            labyrinth[positionRow, positionColumn]--;
        }
        Console.WriteLine(coins);
    }
}