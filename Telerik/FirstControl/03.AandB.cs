using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class AandB
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        string[] token = Console.ReadLine().Split();
        string element1 = token[0];
        string element2 = token[1];
        Queue<string> variations = new Queue<string>();
        variations.Enqueue(element1);
        variations.Enqueue(element2);
        for (int i = 1; i < n; i++)
        {
            int tempCount = variations.Count;
            for (int j = 0; j < tempCount; j++)
            {
                string variant = variations.Dequeue();
                variations.Enqueue(variant + element1);
                variations.Enqueue(variant + element2);
            }
        }
        List<string> variationsList = new List<string>();
        while (variations.Count > 0)
        {
            variationsList.Add(variations.Dequeue());
        }
        foreach (string variant in variationsList.OrderBy(m => m).ToList())
        {
            Console.WriteLine(variant);
        }
    }
}

