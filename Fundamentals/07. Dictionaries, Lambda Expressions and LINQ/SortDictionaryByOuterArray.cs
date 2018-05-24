using System;
using System.Collections.Generic;
using System.Linq;
 
class Snowmen
{
    static void Main()
    {
        int[] ints = { 1, 2, 3, 4 };
 
        Dictionary<int, string> dict = new Dictionary<int, string>()
        {
            {3, "pesho" },
            {2, "stamata" },
            {1, "prakash" },
            {0, "polina" }
        };
 
        foreach (var pair in dict.OrderBy(x => ints[x.Key]))
        {
            Console.WriteLine(pair.Value);
        }
    }
}