import java.util.LinkedList;
import java.util.Queue;
// problem link
// https://leetcode.com/problems/rotting-oranges/

public class rootenOranges {
    class pair {
        int x, y, t;

        pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }


        public static void main(String[] args) {

        int[][] grid=new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        rootenOranges ro=new rootenOranges();
            System.out.println(ro.orangesRotting(grid));
        }

        public int orangesRotting(int[][] grid) {
            int n_row = grid.length;
            int n_col = grid[0].length;
            Queue<pair> q = new LinkedList<>();
            int t = 0;
            outerloop:
            for (int i = 0; i < n_row; i++) {
                for (int j = 0; j < n_col; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new pair(i, j, t));

                        while (!q.isEmpty()) {
                            pair p = q.poll();
                            t = p.t;

                            int[] checkX = new int[]{-1, 1, 0, 0};
                            int[] checkY = new int[]{0, 0, -1, 1};
                            for (int k = 0; k < 4; k++) {
                                int xi = checkX[k] + p.x;
                                int yi = checkY[k] + p.y;
                                if (xi >= 0 && xi < n_row && yi >= 0 && yi < n_col && grid[xi][yi] == 1) {
                                    q.add(new pair(xi, yi, t + 1));
                                    grid[xi][yi] = 2;
                                }
                            }
                        }

                    }
                    break outerloop;
                }
            }


            for (int i = 0; i < n_row; i++) {
                for (int j = 0; j < n_col; j++) {
                    if (grid[i][j] == 1) return -1;
                }
            }
            return t;
        }

    }
