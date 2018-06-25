package Telerik;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolveExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        expression = expression.replaceAll("\\s+", "");
        Long value = CalculateExpression(expression);
        System.out.println(value);
    }

    static Long CalculateExpression(String expression) {
        if (!expression.contains("(")) {
            String pattern2 = "^(\\d+)([+*-])(\\d+)$";
            Pattern ptr2 = Pattern.compile(pattern2);
            Matcher match2 = ptr2.matcher(expression);
            if (match2.find()) {
                Long num1 = Long.parseLong(match2.group(1));
                Long num2 = Long.parseLong(match2.group(3));
                String operand2 = match2.group(2);
                Long value = 0l;
                switch (operand2) {
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
        }
        String pattern = "^(\\d+)([+*-])\\(([\\d()*+-]+)\\)$";
        Pattern ptr = Pattern.compile(pattern);
        Matcher match = ptr.matcher(expression);
        if (match.find()) {
            Long number = Long.parseLong(match.group(1));
            String operand = match.group(2);
            String subexpression = match.group(3);
            switch (operand) {
                case "+":
                    return (number + CalculateExpression(subexpression));
                case "-":
                    return (number - CalculateExpression(subexpression));
                case "*":
                    return (number * CalculateExpression(subexpression));
            }
        }
        return 0l;
    }
}
