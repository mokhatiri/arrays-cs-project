package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        int newCourse = 3000; // The new course to add

        // NewArray
        int[] updatedCourses = new int[registeredCourses.length + 1];

        // Copy old courses into the new array
        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }

        // Add the new course at the end
        updatedCourses[updatedCourses.length - 1] = newCourse;

        // Print
        System.out.println("Updated courses:  " + Arrays.toString(updatedCourses));

        // check if a course exists
        int searchCourse = 2150;
        boolean found = false;
        for (int course : updatedCourses) {
            if (course == searchCourse) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Course " + searchCourse + " is in the list.");
        } else {
            System.out.println("Course " + searchCourse + " is NOT in the list.");
        }
    }
}
