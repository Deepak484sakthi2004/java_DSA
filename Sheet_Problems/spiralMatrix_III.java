import java.util.List;
import java.util.ArrayList;

// problem link:
//  https://leetcode.com/problems/spiral-matrix-iii/description/

public class spiralMatrix_III {
    static class Pair<I extends Number, I1 extends Number> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int axisX[] = new int[]{1, 0, -1, 0};
        int axisY[] = new int[]{0, 1, 0, -1};
        // (1,0),(0,1),(-1,1),(1,-1)
        int x, y;
        x = 4;
        y = 3;

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int nRow = matrix.length;
        int nCol = matrix[0].length;

        List<Pair<Integer, Integer>> l = new ArrayList<>();

        int[][] visited = new int[nRow * nCol][2];


        int ind = 0;
        visited[ind++] = new int[]{x, y};
        int pos = 0;
        int d = 0;
        while (ind < nRow * nCol) {

            if (pos == 0) {
                d++;
            }
            for (int k = 0; k < d; k++) {
                x += axisX[pos];
                y += axisY[pos];
                if (x < nRow && x >= 0 && y < nCol && y >= 0) {
                    visited[ind++] = new int[]{x, y};
                }
                System.out.println(x + " " + y);
                pos = ++pos % 4;
            }

        }
        
//        for (int[] i : visited) {
//            for (int j : i)
//              //  System.out.print(j + " ");
//        }
//        System.out.println();
//
}
}
