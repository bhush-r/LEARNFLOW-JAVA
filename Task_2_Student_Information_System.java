import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private Map<String, Integer> courseGrades;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courseGrades = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCourseGrades() {
        return courseGrades;
    }

    public void addGrade(String course, int grade) {
        courseGrades.put(course, grade);
    }

    public int getAverageGrade() {
        if (courseGrades.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (int grade : courseGrades.values()) {
            total += grade;
        }

        return total / courseGrades.size();
    }
}

class StudentInformationSystem {
    private ArrayList<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name) {
        Student student = new Student(studentId, name);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void registerCourse(String studentId, String course) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.addGrade(course, -1); // Assuming -1 represents an ungraded course
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void assignGrade(String studentId, String course, int grade) {
        Student student = findStudent(studentId);
        if (student != null && student.getCourseGrades().containsKey(course)) {
            student.addGrade(course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void generateTranscript(String studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            System.out.println("Transcript for " + student.getName() + " (ID: " + student.getStudentId() + "):");

            for (Map.Entry<String, Integer> entry : student.getCourseGrades().entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Grade: " + entry.getValue());
            }

            System.out.println("Average Grade: " + student.getAverageGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

public class Task_2_Student_Information_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInformationSystem sis = new StudentInformationSystem();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. Generate Transcript");
            System.out.println("5. Exit");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.next();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.next();
                        sis.addStudent(studentId, name);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        String regStudentId = scanner.next();
                        System.out.print("Enter Course Name: ");
                        String course = scanner.next();
                        sis.registerCourse(regStudentId, course);
                        break;
                    case 3:
                        System.out.print("Enter Student ID: ");
                        String gradeStudentId = scanner.next();
                        System.out.print("Enter Course Name: ");
                        String gradeCourse = scanner.next();
                        System.out.print("Enter Grade: ");
                        int grade = scanner.nextInt();
                        sis.assignGrade(gradeStudentId, gradeCourse, grade);
                        break;
                    case 4:
                        System.out.print("Enter Student ID: ");
                        String transStudentId = scanner.next();
                        sis.generateTranscript(transStudentId);
                        break;
                    case 5:
                        System.out.println("Exiting the Student Information System. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } else {
                // If the input is not an integer, consume the invalid input
                scanner.next();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
