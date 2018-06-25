using System;
using System.Collections.Generic;
using System.Linq;

class ArraySearch
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
        int n = array.Length;
        bool[] bitmap = new bool[n + 1];
        for (int i = 0; i < n; i++)
        {
            bitmap[array[i]] = true;
        }
        List<int> missingNumbers = new List<int>();
        for (int i = 1; i <= n; i++)
        {
            if (!bitmap[i])
            {
                missingNumbers.Add(i);
            }
        }
        Console.WriteLine(string.Join(",", missingNumbers));

    }
}

