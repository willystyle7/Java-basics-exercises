package Telerik;

import java.util.*;

public class ValidateParanthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.equals("")) {
                System.out.println("yes");
                continue;
            }
            Boolean isValid = false;
            ArrayList<String> possibleExpressions = new ArrayList<String>();
            Queue<String> expressions = new LinkedList<String>();
            expressions.add(line);
            while (expressions.size() > 0) {
                String currentExpression = expressions.remove();
                if (currentExpression.contains("*")) {
                    expressions.add(ReplaceFirst(currentExpression, "("));
                    expressions.add(ReplaceFirst(currentExpression, ")"));
                    expressions.add(ReplaceFirst(currentExpression, ""));
                } else {
                    possibleExpressions.add(currentExpression);
                }
            }
            for (int j = 0; j < possibleExpressions.size(); j++) {
                if (isVadidExpression(possibleExpressions.get(j))) {
                    isValid = true;
                    break;
                }
            }
            //System.out.println(String.join("\n", possibleExpressions));
            System.out.println(isValid ? "yes" : "no");
        }
    }

    static String ReplaceFirst(String expression, String replacer) {
        int index = expression.indexOf('*');
        String newExpression = "";
        newExpression = expression.substring(0, index) + replacer + expression.substring(index + 1);
        return newExpression;
    }

    static Boolean isVadidExpression(String expression) {
        Stack<Boolean> validations = new Stack<Boolean>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                validations.push(true);
            }
            if (expression.charAt(i) == ')' && validations.size() > 0) {
                validations.pop();
            } else if (expression.charAt(i) == ')' && validations.size() == 0) {
                return false;
            }
        }
        if (validations.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
