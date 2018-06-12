using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class ExpressionAgain
{
    static void Main()
    {
        char[] digits = Console.ReadLine().ToCharArray();
        int controlExp = int.Parse(Console.ReadLine());
        int counter = 0;
        Queue<string> expressions = new Queue<string>();        
        expressions.Enqueue(digits[0].ToString());
        for (int i = 1; i < digits.Length; i++)
        {
            int tempCount = expressions.Count;
            for (int j = 0; j < tempCount; j++)
            {
                string exp = expressions.Dequeue();
                expressions.Enqueue(exp + "*" + digits[i].ToString());
                expressions.Enqueue(exp + "+" + digits[i].ToString());
                expressions.Enqueue(exp + "-" + digits[i].ToString());
                if (digits[i - 1] != '0')
                {
                    expressions.Enqueue(exp + "" + digits[i].ToString());
                }
                else if (exp.Length >= 2 && exp[exp.Length - 2] != '*' && exp[exp.Length - 2] != '+' && exp[exp.Length - 2] != '-')
                {
                    expressions.Enqueue(exp + "" + digits[i].ToString());
                }                
            }
        }
        while (expressions.Count > 0)
        {
            string expression = expressions.Dequeue();
            if (EvaluateExression(expression) == controlExp)
            {
                counter++;
            }
            //Console.WriteLine(expression);
            //Console.WriteLine(EvaluateExression(expression));
        }
        Console.WriteLine(counter);
    }

    static int EvaluateExression(string expression)
    {
        int sum = 0;
        string patternNumbers = @"\d+";
        string patternOperators = @"[+*-]{1}";
        MatchCollection matchesNumbers = Regex.Matches(expression, patternNumbers);
        MatchCollection matchesOperators = Regex.Matches(expression, patternOperators);
        sum = int.Parse(matchesNumbers[0].Value);
        for (int i = 1; i < matchesNumbers.Count; i++)
        {
            switch (matchesOperators[i - 1].Value)
            {
                case "+":
                    sum += int.Parse(matchesNumbers[i].Value);
                    break;
                case "-":
                    sum -= int.Parse(matchesNumbers[i].Value);
                    break;
                case "*":
                    sum *= int.Parse(matchesNumbers[i].Value);
                    break; 
            }
        }
        return sum;
    }
}

