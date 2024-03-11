package Striver.Graphs.DFS_BFS_Problems;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;
public class NearestCellOne {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
//                {
//                        {0,1,1,0},
//                        {1,1,0,0},
//                        {0,0,1,1}
//                };
                {
                        {1,0,0,0},
                        {1,0,0,1},
                        {0,1,0,0},
                        {1,0,1,0}
                };


        // convert the zeroes to their respective distance to their
        // ones, its like rotten oranges!!
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        bfs(matrix, vis);

        for(int[] i :matrix)
        {
            System.out.println(Arrays.toString(i));
        }
    }

    private static void bfs(int[][] m, boolean[][] vis)
    {
        Queue<Pair> q = new LinkedList<>();

        int nRow= m.length;
        int nCol = m[0].length;

        for(int i=0;i<nRow;i++)
        {
            for(int j=0;j<nCol ; j++)
            {
                if(m[i][j]==1)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = true;
                }

            }
        }
        // so now all the ones are inside the queue!!
        int[] d = new int[]{0,1,0,-1,0};

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int x = p.a;
            int y = p.b;
            int grad = p.grad;

            m[x][y] = grad ;


            for(int i=0;i<4;i++) {
                int xi = x + d[i];
                int yi = y + d[i + 1];

                if (xi >= 0 && xi < nRow && yi >= 0 && yi < nCol && m[xi][yi] == 0 && vis[xi][yi]==false)
                {
                    vis[xi][yi] = true;
                    q.offer(new Pair(xi,yi,grad+1));
                }
            }
        }
    }

    private static class Pair
    {
        int a,b,grad;
        Pair(int a,int b,int grad)
        {
            this.a  = a;
            this.b =  b;
            this.grad = grad;
        }
    }
}

