package Striver.Graphs.DFS_BFS_Problems;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

// given a 2d matrix, the src node, if the adjacent nodes are of the same color, fill it with
// the destination color!!
public class floodFill {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1,2,2,1},
                        {1,2,3,1},
                        {1,1,1,1},
                        {1,0,1,2}
                };

        int sr = 3; // source row
        int sc = 0; // source column
        int colorChange = 9 ; // change the color the 9 ;
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int initialColor = matrix[sr][sc];

        bfsApproach(matrix,vis,sr,sc,colorChange,initialColor);
        System.out.println(initialColor);
        System.out.println("THE FINAL RESULT IS:\n\n");
        for(int[] i :matrix)
        {
            System.out.println(Arrays.toString(i));
        }

    }

    private static void dfsApproach(int[][] m, int sr,int sc,int change,boolean[][] vis,int initialColor)
    {

        vis[sr][sc] = true;
        m[sr][sc] = change;

        int nRow = m.length;
        int nCol = m[0].length;

        int[] dir = new int[] {0,1,0,-1,0};
        // (0,1) (1,0)    (0,-1)  (-1,0)
        for(int i=0;i<4;i++)
        {
            int ri = sr+dir[i];
            int ci = sc+dir[i+1];

            if(ri>=0 && ri<nRow && ci>=0 && ci<nCol && vis[ri][ci]==false && m[ri][ci]==initialColor)
                dfsApproach(m,ri,ci,change,vis,initialColor);
        }
//        for(int[] i :m)
//        {
//            System.out.println(Arrays.toString(i));
//        }
//        System.out.println("\n");

    }

    private static void bfsApproach(int[][] m, boolean[][] vis, int sr, int sc, int initialColor, int change) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));

        int nRow = m.length;
        int nCol = m[0].length;

        int[] d = new int[]{0, 1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.a;
            int y = p.b;
            System.out.println(x + " " + y);

            m[x][y] = change;
            vis[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int xi = x + d[i];
                int yi = y + d[i + 1];

                if (xi >= 0 && xi < nRow && yi >= 0 && yi < nCol && vis[xi][yi] == false && m[xi][yi] == initialColor) {
                    q.offer(new Pair(xi, yi));
                }
            }

            for(int i=0;i<q.size();i++)
            {
                System.out.println(q.poll());
            }
        }
    }


    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
