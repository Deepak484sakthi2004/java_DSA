package Striver.Interview;

import java.util.Arrays;

public class MinimizeTheMaximumPagesInBookForStudents {

    private static boolean isValid(int[] pages, int students, int mid) {
        int currSum = 0;
        int currStudents = 1;

        for (int page : pages) {
            currSum += page;
            if (currSum > mid) {
                currStudents++;
                currSum = page;
            }
        }

        return currStudents <= students;
    }

    private static int findMinMax(int[] pages, int students) {
        int len = pages.length;
        if (len < students) return -1; // Not enough books for each student
        if (len == students) return Arrays.stream(pages).max().getAsInt(); // Each book for one student

        int low = Arrays.stream(pages).min().getAsInt();
        int high = Arrays.stream(pages).sum();
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(low+" "+high+" "+mid);
            if (isValid(pages, students, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] pages = {21, 23, 32, 43, 54, 65, 67, 77, 82};
        int students = 3;
        int minMaxPages = findMinMax(pages, students);
        if (minMaxPages != -1) {
            System.out.println("Minimum of maximum pages that a student can read: " + minMaxPages);
        } else {
            System.out.println("Invalid input. Number of books is less than number of students.");
        }
    }
}
