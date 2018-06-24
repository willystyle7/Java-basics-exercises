using System;
using System.Collections.Generic;

class ValidateParanthesis
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        for (int i = 0; i < n; i++)
        {
            string line = Console.ReadLine();
            if (line == string.Empty)
            {
                Console.WriteLine("yes");
                continue;
            }
            bool isValid = false;
            List<string> possibleExpressions = new List<string>();
            Queue<string> expressions = new Queue<string>();
            expressions.Enqueue(line);
            while (expressions.Count > 0)
            {
                string currentExpression = expressions.Dequeue();
                if (currentExpression.Contains("*"))
                {
                    expressions.Enqueue(ReplaceFirst(currentExpression, "("));
                    expressions.Enqueue(ReplaceFirst(currentExpression, ")"));
                    expressions.Enqueue(ReplaceFirst(currentExpression, ""));
                }
                else
                {
                    possibleExpressions.Add(currentExpression);
                }
            }
            for (int j = 0; j < possibleExpressions.Count; j++)
            {
                if (isVadidExpression(possibleExpressions[j]))
                {
                    isValid = true;
                    break;
                }
            }
            //Console.WriteLine(String.Join("\n", possibleExpressions));
            Console.WriteLine(isValid ? "yes" : "no");
        }
    }

    static string ReplaceFirst(string expression, string replacer)
    {
        int index = expression.IndexOf('*');
        string newExpression = string.Empty;
        newExpression = expression.Substring(0, index) + replacer + expression.Substring(index + 1);
        return newExpression.ToString();
    }

    static bool isVadidExpression(string expression)
    {        
        Stack<bool> validations = new Stack<bool>();
        for (int i = 0; i < expression.Length; i++)
        {
            if (expression[i] == '(')
            {
                validations.Push(true);
            }
            if (expression[i] == ')' && validations.Count > 0)
            {
                validations.Pop();
            }
            else if (expression[i] == ')' && validations.Count == 0)
            {
                return false;
            }
        }
        if (validations.Count == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
