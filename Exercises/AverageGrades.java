import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AverageGrades {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            students.add(readStudent(scan));
        }
        students.stream()
                .filter((x) -> x.getAvgGrade() >= 5.00)
                .sorted(Comparator.comparing(Student::getName).thenComparing(Student::getAvgGrade, Comparator.reverseOrder()))
                .forEach((x) -> System.out.printf("%s -> %.2f%n", x.getName(), x.getAvgGrade()));
    }

    private static Student readStudent(Scanner scan) {
        String[] inputs = scan.nextLine().split(" ");
        String name = inputs[0];
        Student student = new Student(name);
        for (int i = 1; i < inputs.length; i++) {
            student.getGrades().add(Double.parseDouble(inputs[i]));
        }
        return student;
    }
}

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<Double>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public double getAvgGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}