package SKILLRACK.tests;

import java.util.Arrays;

public class KnightReachesEnemyKing {

    public static void main(String[] args) {
        String[][] board = new String[][] {
                {"K","X","Y","X","E"},
                {"X","X","Y","X","X"},
                {"X","X","Y","X","X"},
                {"X","X","Y","X","X"},
                {"X","X","Y","X","X"}
        };
        int n = board.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(board, 0, 0, 0, 4, dp,0));
    }
    private static int memo(String[][] a, int x, int y, int m, int n, int[][] dp, int depth) {
        System.out.print(getIndentation(depth));
        System.out.println("memo(a, " + x + ", " + y + ", " + m + ", " + n + ", dp)");

        int nRow = a.length;
        if (x < 0 || y < 0 || x >= nRow || y >= nRow) return Integer.MAX_VALUE;

        if (x == m && y == n) return 0;

        if (dp[x][y] != -1) return dp[x][y];

        int[][] d = {
                {2, 1}, {2, -1}, {-1, -2}, {-2, 1}, {1, -2}, {1, 2}, {-2, -1}, {-1, 2}
        };

        int out = Integer.MAX_VALUE;
        for (int[] i : d) {
            int xi = x + i[0];
            int yi = y + i[1];
            if (xi >= 0 && yi >= 0 && xi < nRow && yi < nRow && !a[xi][yi].equals("Y")) {
                int steps = memo(a, xi, yi, m, n, dp,depth+1);
                if (steps != Integer.MAX_VALUE) {
                    out = Math.min(steps + 1, out);
                }
            }
        }

        if (out != Integer.MAX_VALUE) {
            return dp[x][y] = out;
        } else {
            return dp[x][y] = Integer.MAX_VALUE;
        }
    }
    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("    "); // 4 spaces for each level of indentation
        }
        return indentation.toString();
    }
//    private static int memo(String[][] a, int x, int y, int m, int n, int[][] dp) {
//        int nRow = a.length;
//        if (x < 0 || y < 0 || x >= nRow || y >= nRow) return Integer.MAX_VALUE;
//
//        if (x == m && y == n) return 0;
//
//        if (dp[x][y] != -1) return dp[x][y];
//
//        int[][] d = {
//                {2, 1}, {2, -1}, {-1, -2}, {-2, 1}, {1, -2}, {1, 2}, {-2, -1}, {-1, 2}
//        };
//
//        int out = Integer.MAX_VALUE;
//        for (int[] i : d) {
//            int xi = x + i[0];
//            int yi = y + i[1];
//            if (xi >= 0 && yi >= 0 && xi < nRow && yi < nRow && !a[xi][yi].equals("Y")) {
//                int steps = memo(a, xi, yi, m, n, dp);
//                if (steps != Integer.MAX_VALUE) {
//                    out = Math.min(steps + 1, out);
//                }
//            }
//        }
//        return dp[x][y] = out;
//    }

}
