package samplearrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;

        for (Student student : students) {
            if (student.getAge() >= 18) {
                count++;
            }
        }

        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        Student goal = null;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                goal = student;
            }
        }
        return goal;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (a, b) -> Integer.compare(b.getGrade(), a.getGrade()));
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        // grade greater or equal 15
        System.out.print("High Achievers: ");
        for (Student student : students) {
            if (student.getGrade() >= 15) {
                System.out.print(student.getName() + " . ");
            }
        }
        System.out.println();
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                return true; // grade updated
            }
        }
        return false; // id not found
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        HashSet<String> seen = new HashSet<>(); // using a hashSet -> the best way to determine preexisting names
        for (Student s : students) {
            if (!seen.add(s.getName())) {
                return true;
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = newStudent;

        return newStudents;
    }

    // 11)
    public static Student findTopStudent (Student[]classStudents){
        Student top = classStudents[0];
        for (Student s : classStudents) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }
        return top;
    }


    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Ahmed", 20, 14),
                new Student(2, "Sara", 17, 16),
                new Student(3, "Ali", 19, 13),
                new Student(4, "Dina", 21, 15),
                new Student(5, "Ahmed", 22, 12) // duplicate name to test
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest student: " + findOldest(arr));

        // 3) Count adults
        System.out.println("The count of adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade of all students: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("found student \" ahmed \" " + findStudentByName(arr, "ahmed"));


        // 6) Sort by grade desc
        sortByGradeDesc(arr);

        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id

        // function
        boolean updated = updateGrade(arr, 4, 17);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\nHas duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student
        Student newS = new Student(6, "Nora", 18, 17);
        arr = appendStudent(arr, newS);
        System.out.println("\nAfter appending new student:");
        for (Student s : arr) System.out.println(s);


        // Create 2D array: 2 classes, each with 3 students
        Student[][] school = new Student[2][3];

        // Fill the array
        school[0][0] = new Student(1, "Ahmed", 20, 14);
        school[0][1] = new Student(2, "Sara", 17, 18);
        school[0][2] = new Student(3, "Ali", 19, 12);

        school[1][0] = new Student(4, "Dina", 21, 15);
        school[1][1] = new Student(5, "Omar", 18, 16);
        school[1][2] = new Student(6, "Nora", 18, 19);

        // Print all students class by class
        System.out.println("=== Students by Class ===");
        for (int i = 0; i < school.length; i++) {
            System.out.println("Class " + (i + 1) + ":");
            for (int j = 0; j < school[i].length; j++) {
                System.out.println("  " + school[i][j]);
            }
            System.out.println();
        }

        // Find and print top student in each class
        System.out.println("=== Top Student in Each Class ===");
        for (int i = 0; i < school.length; i++) {
            Student top = findTopStudent(school[i]);
            System.out.println("Class " + (i + 1) + " → Top Student: " + top.getName() + " (Grade: " + top.getGrade() + ")");
        }
    }
}
