package DialyLeetCode;
import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // return the first and last occurrences of the target using binary search.
        int start = BSFloor(nums, target);
        int end = BSCeil(nums, target);
        return new int[]{start, end};
    }

    public static int BSFloor(int[] a, int t) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (t == a[mid]) {
                // Found a potential occurrence, move left to find the first occurrence
                end = mid - 1;
            } else if (t > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Check if the target was found, otherwise return -1
        return (start < a.length && a[start] == t) ? start : -1;
    }

    public static int BSCeil(int[] a, int t) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (t == a[mid]) {
                // Found a potential occurrence, move right to find the last occurrence
                start = mid + 1;
            } else if (t > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Check if the target was found, otherwise return -1
        return (end >= 0 && a[end] == t) ? end : -1;
    }
}

public class firstLastOccurrence_BS {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1, 3, 4, 4, 4, 4, 5, 6, 6, 7, 8, 9, 9};
        int[] res = s.searchRange(a, 4);
        System.out.println(Arrays.toString(res));
    }
}
