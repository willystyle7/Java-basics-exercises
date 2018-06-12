package Telerik;

import java.util.*;

public class ExpressionAgain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] digits = scan.nextLine().toCharArray();
        int controlExp = Integer.parseInt(scan.nextLine());
        int counter = 0;
        Queue<String> expressions = new LinkedList<String>();
        expressions.add(String.valueOf(digits[0]));
        for (int i = 1; i < digits.length; i++) {
            int tempCount = expressions.size();
            for (int j = 0; j < tempCount; j++) {
                String exp = expressions.remove();
                expressions.add(exp + "*" + digits[i]);
                expressions.add(exp + "+" + digits[i]);
                expressions.add(exp + "-" + digits[i]);
                if (digits[i - 1] != '0') {
                    expressions.add(exp + "" + digits[i]);
                } else if (exp.length() >= 2 && exp.charAt(exp.length() - 2) != '*' && exp.charAt(exp.length() - 2) != '+' && exp.charAt(exp.length() - 2) != '-') {
                    expressions.add(exp + "" + digits[i]);
                }
            }
        }
        while (expressions.size() > 0) {
            String expression = expressions.remove();
            if (EvaluateExression(expression) == controlExp) {
                counter++;
            }
            //System.out.println(expression);
            //System.out.println(EvaluateExression(expression));
        }
        System.out.println(counter);
    }

    public static int EvaluateExression(String expression) {
        int sum = 0;
        String[] matchesNumbers = expression.split("[+*-]{1}");
        String[] matchesOperators = expression.split("\\d+");
        matchesNumbers = clean(matchesNumbers);
        matchesOperators = clean(matchesOperators);
        sum = Integer.parseInt(matchesNumbers[0]);
        for (int i = 1; i < matchesNumbers.length; i++) {
            switch (matchesOperators[i - 1]) {
                case "+":
                    sum += Integer.parseInt(matchesNumbers[i]);
                    break;
                case "-":
                    sum -= Integer.parseInt(matchesNumbers[i]);
                    break;
                case "*":
                    sum *= Integer.parseInt(matchesNumbers[i]);
                    break;
            }
        }
        return sum;
    }

    public static String[] clean(final String[] arr) {
        List<String> list = new ArrayList<String>(Arrays.asList(arr));
        list.removeAll(Collections.singleton(null));
        list.removeAll(Collections.singleton(""));
        return list.toArray(new String[list.size()]);
    }
}
