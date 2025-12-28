import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    int getMax() {
        int max = grades.get(0);
        for (int g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    int getMin() {
        int min = grades.get(0);
        for (int g : grades) {
            if (g < min) min = g;
        }
        return min;
    }

    boolean isPassed() {
        return getAverage() >= 50;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student;

        System.out.print("Enter student name: ");
        student = new Student(sc.nextLine());

        System.out.print("How many grades? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter grade " + i + ": ");
            student.addGrade(sc.nextInt());
        }

        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + student.name);
        System.out.println("Average: " + student.getAverage());
        System.out.println("Highest: " + student.getMax());
        System.out.println("Lowest: " + student.getMin());
        System.out.println("Status: " + (student.isPassed() ? "PASSED" : "FAILED"));

        sc.close();
    }
}

