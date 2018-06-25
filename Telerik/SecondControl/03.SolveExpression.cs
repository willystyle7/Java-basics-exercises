using System;
using System.Text.RegularExpressions;

class SolveExpression
{
    static void Main()
    {
        string expression = Console.ReadLine();
        expression = Regex.Replace(expression, "\\s+", "");
        long value = CalculateExpression(expression);
        Console.WriteLine(value);
    }

    static long CalculateExpression(string expression)
    {
        if (!expression.Contains("("))
        {
            string pattern2 = @"^(\d+)([+*-])(\d+)$";
            Match match2 = Regex.Match(expression, pattern2);
            long num1 = long.Parse(match2.Groups[1].Value);
            long num2 = long.Parse(match2.Groups[3].Value);
            string operand2 = match2.Groups[2].Value;
            long value = 0;
            switch (operand2)
            {
                case "+":
                    value = num1 + num2;
                    break;
                case "-":
                    value = num1 - num2;
                    break;
                case "*":
                    value = num1 * num2;
                    break;
            }
            return value;
        }
        string pattern = @"^(\d+)([+*-])\(([\d()*+-]+)\)$";
        Match match = Regex.Match(expression, pattern);
        long number = long.Parse(match.Groups[1].Value);
        string operand = match.Groups[2].Value;
        string subexpression = match.Groups[3].Value;
        switch (operand)
        {
            case "+":
                return (number + CalculateExpression(subexpression));
                break;
            case "-":
                return (number - CalculateExpression(subexpression));
                break;
            case "*":
                return (number * CalculateExpression(subexpression));
                break;
        }
        return 0;
    }
}

