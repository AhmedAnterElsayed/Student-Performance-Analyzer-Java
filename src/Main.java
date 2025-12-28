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
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("How many students? ");
        int studentCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int s = 1; s <= studentCount; s++) {

            System.out.print("\nEnter name of student " + s + ": ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("How many grades for " + name + "? ");
            int gradeCount = sc.nextInt();

            for (int i = 1; i <= gradeCount; i++) {
                System.out.print("Enter grade " + i + ": ");
                student.addGrade(sc.nextInt());
            }

            sc.nextLine(); // consume newline
            students.add(student);
        }

        System.out.println("\n===== STUDENTS REPORT =====");

        for (Student st : students) {
            System.out.println("\nName: " + st.name);
            System.out.println("Average: " + st.getAverage());
            System.out.println("Highest: " + st.getMax());
            System.out.println("Lowest: " + st.getMin());
            System.out.println("Status: " + (st.isPassed() ? "PASSED" : "FAILED"));
        }

        sc.close();
    }
}
