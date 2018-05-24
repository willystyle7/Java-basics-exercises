package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AwesomeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int favouriteNumber = Integer.parseInt(reader.readLine());
        int conditionsMet = getConditionsMet(number, favouriteNumber);
        printOutput(conditionsMet);
    }

    private static void printOutput(int conditionsMet) {
        if (conditionsMet == 3) {
            System.out.println("super special awesome");
        } else if (conditionsMet == 2) {
            System.out.println("super awesome");
        } else if (conditionsMet == 1) {
            System.out.println("awesome");
        } else {
            System.out.println("boring");
        }
    }

    private static int getConditionsMet(int number, int favouriteNumber) {
        int conditionsMet = 0;
        if (number % 2 == 1 || number % 2 == -1) {
            conditionsMet++;
        }
        if (number < 0) {
            conditionsMet++;
        }
        if (number % favouriteNumber == 0) {
            conditionsMet++;
        }
        return conditionsMet;
    }
}