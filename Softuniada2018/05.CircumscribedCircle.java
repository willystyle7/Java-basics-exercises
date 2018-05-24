package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircumscribedCircle {

    private static double circleX;
    private static double circleY;
    private static double circleR;
    private static double x1;
    private static double y1;
    private static double x2;
    private static double y2;
    private static double x3;
    private static double y3;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            readInput(reader);
            boolean isCircumscribed = checkIfCircumscribed();
            boolean isInside = isCenterInside();
            System.out.print(isCircumscribed ? "The circle is circumscribed " : "The circle is not circumscribed ");
            System.out.println(isInside ? "and the center is inside." : "and the center is outside.");
        }
    }

    private static boolean isCenterInside() {
        double area = calcArea(x1, y1, x2, y2, x3, y3);
        double area1 = calcArea(circleX, circleY, x2, y2, x3, y3);
        double area2 = calcArea(x1, y1, circleX, circleY, x3, y3);
        double area3 = calcArea(x1, y1, x2, y2, circleX, circleY);
        return Math.abs(area - (area1 + area2 + area3)) < 0.01;
    }

    private static double calcArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    private static void readInput(BufferedReader reader) throws IOException {
        String[] tokens = reader.readLine().split(" |, ");
        circleX = Double.parseDouble(tokens[1]);
        circleY = Double.parseDouble(tokens[2]);
        circleR = Double.parseDouble(tokens[3]);
        tokens = reader.readLine().split(" |, ");
        x1 = Double.parseDouble(tokens[1]);
        y1 = Double.parseDouble(tokens[2]);
        x2 = Double.parseDouble(tokens[3]);
        y2 = Double.parseDouble(tokens[4]);
        x3 = Double.parseDouble(tokens[5]);
        y3 = Double.parseDouble(tokens[6]);
    }

    private static boolean checkIfCircumscribed() {
        double firstVertexDistance = getDistance(x1, y1, circleX, circleY);
        double secondVertexDistance = getDistance(x2, y2, circleX, circleY);
        double thirdVertexDistance = getDistance(x3, y3, circleX, circleY);
        return !(Math.abs(firstVertexDistance - circleR) > 0.01)
                && !(Math.abs(secondVertexDistance - circleR) > 0.01)
                && !(Math.abs(thirdVertexDistance - circleR) > 0.01);
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        double xDiff = Math.abs(x1 - x2);
        double yDiff = Math.abs(y1 - y2);
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}