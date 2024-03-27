package SKILLRACK.tests;
import java.util.Arrays;

// Given the credits points, return the maximum credit points

public class NinjaPracticesPoints {

    public static void main(String[] args) {
        int[][] a = new int[][]{{18, 11, 19},
                {4, 13, 7},
                {1, 8, 13}};
        // do it column wise!!, the columns are day now!!

        System.out.println(ninjaPoint(a));

    }

    private static int ninjaPoint(int[][] a) {
        int nRow = a.length;
        int nCol = a[0].length;
        int[][] dp = new int[nRow][nCol];

        for (int[] i : dp)
            Arrays.fill(i, -1);

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nRow; i++) {
            maxi = Math.max(maxi, memo(a, nCol - 1, i, dp));
        }
        return maxi;
    }

    private static int memo(int[][] a, int col, int prevRow, int[][] dp) {
        int nRow = a.length;
        if (col == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nRow; i++) {
                if (i != prevRow)
                    max = Math.max(max, a[i][0]);
            }
            return max;
        }
        if (dp[prevRow][col] != -1) return dp[prevRow][col];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nRow; i++) {
            max = Math.max(max, a[i][col] + memo(a, col - 1, i, dp));
        }
        return dp[prevRow][col] = max;
    }
}
//    private class other {
//        public static void main(String[] args) {
//            int[][] a = new int[][]{{18, 11, 19},
//                    {4, 13, 7},
//                    {1, 8, 13}};//new int[][]{
////                {1,2,3,4}, //day1
////                {1,1,1,3}, //day2
////                {2,2,2,3}, // day3
////                {1,1,1,3} //day4
////                                };
//            int nRow = a.length;
//            int nCol = a[0].length;
//
//            System.out.println(ninjaPoints(a, nRow, nCol));
//
//        }
//
//        private static int ninjaPoints(int[][] a, int r, int c) {
//            int[][] dp = new int[r][c];
//            for (int[] temp : dp) {
//                Arrays.fill(temp, -1);
//            }
//
//            int maxi = Integer.MIN_VALUE;
//            for (int i = 0; i < c; i++) {
//                maxi = Math.max(maxi, memo(a, r - 1, i, dp));
//                System.out.println("==============================================================================");
//            }
//
//            for (int[] k : dp) {
//                System.out.println(Arrays.toString(k));
//            }
//            return maxi;
//        }
//
//        private static int memo(int[][] a, int row, int prevCol, int[][] dp) {
//            System.out.println("row " + row);
//            System.out.println("prevcol: " + prevCol);
//
//            int nRow = a.length;
//            int nCol = a[0].length;
//
//            if (row == 0) {
//                int maxi = Integer.MIN_VALUE;
//                for (int i = 0; i < nCol; i++) {
//                    if (i != prevCol)
//                        maxi = Math.max(maxi, a[row][i]);
//                }
//                return maxi;
//            }
//            if (dp[row][prevCol] != -1) return dp[row][prevCol];
//
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < nCol; i++) {
//                if (i != prevCol)
//                    max = Math.max(max, a[row][i] + memo(a, row - 1, i, dp));
//            }
//            System.out.println("the return value for " + row + " " + " is :" + max);
//            return dp[row][prevCol] = max;
//        }
//    }

