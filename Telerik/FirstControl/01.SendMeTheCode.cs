using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class SendMeTheCode
{
    static void Main()
    {
        string number = Math.Abs(int.Parse(Console.ReadLine())).ToString();
        int result = 0;
        for (int i = 0; i < number.Length; i++)
        {
            int index = number.Length - i;
            int digit = number[i] - '0';
            if (index % 2 == 0)
            {
                result += digit * digit * index;
            }
            else
            {
                result += digit * index * index;
            }
        }
        int lengthMessage = result % 10;
        int startMessage = result % 26 + 1;
        if (lengthMessage == 0)
        {
            Console.WriteLine(result);
            Console.WriteLine("Big Vik wins again!");
        }
        else
        {
            string resultMessage = "";
            int indexMessage = startMessage;
            for (int i = 1; i <= lengthMessage; i++)
            {
                resultMessage += (char)(64 + indexMessage);                
                indexMessage = indexMessage % 26 + 1;
            }
            Console.WriteLine(result);
            Console.WriteLine(resultMessage);
        }

    }
}

