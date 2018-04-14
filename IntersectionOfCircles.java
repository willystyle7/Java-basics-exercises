import java.util.Scanner;

public class IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Circle c1 = readCircle(scan);
        Circle c2 = readCircle(scan);
        System.out.println(Intersect(c1, c2) ? "Yes" : "No");
    }

    private static Circle readCircle(Scanner scan) {
        String[] inputs = scan.nextLine().split(" ");
        double x = Double.parseDouble(inputs[0]);
        double y = Double.parseDouble(inputs[1]);
        double radius = Double.parseDouble(inputs[2]);
        return new Circle(new Point(x, y), radius);
    }

    private static boolean Intersect(Circle c1, Circle c2) {
        double dist = Math.sqrt(Math.pow((c2.getCenter().getX() - c1.getCenter().getX()), 2) +
                Math.pow((c2.getCenter().getY() - c1.getCenter().getY()), 2));
        return dist <= c1.getRadius() + c2.getRadius();
    }
}

class Point {
    private double X;
    private double Y;

    public Point(double x, double y) {
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }
    public double getRadius() {
        return radius;
    }
}