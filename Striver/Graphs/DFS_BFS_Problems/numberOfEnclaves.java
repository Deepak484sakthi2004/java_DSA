package Striver.Graphs.DFS_BFS_Problems;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


// 1020. Number of Enclaves

public class numberOfEnclaves {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {0}, {1},{1},{0},{0}
                };
//                {
//                        {0,1,1,0,0},
//                        {0,1,0,1,0},
//                        {0,0,1,1,0},
//                        {0,1,0,0,0},
//                        {1,0,1,1,1}
//                };
        int nRow =  matrix.length;
        int nCol = matrix[0].length;
        boolean[][] vis = new boolean[nRow][nCol];

        for(int i=0;i<nRow;i++)
        {
            if( matrix[i][0]==1 && vis[i][0]==false)
                dfs(i,0,matrix,vis);

            if(matrix[i][nCol-1]==1 && vis[i][nCol-1]==false)
                dfs(i,nCol-1,matrix,vis);
        }
        for(int i=0;i<nCol;i++)
        {
            if(matrix[0][i]==1 && vis[0][i]==false)
                dfs(0,i,matrix,vis);


            if(matrix[nRow-1][i]==1 && vis[nRow-1][i]==false)
                dfs(nRow-1,i,matrix,vis);
        }

        int count=0;
        for(int i=0;i<nRow;i++)
        {
            for(int j=0;j<nCol;j++)
            {
                if(matrix[i][j]==1 && vis[i][j]==false)
                    count++;
            }
        }
        System.out.println(count);

    }
    private static void dfs(int x,int y,int[][] m,boolean[][] vis) {
        vis[x][y] = true;
        int nRow = m.length;
        int nCol = m[0].length;

        int[] d = new int[]{0, 1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int xi = x + d[i];
            int yi = y + d[i + 1];

            if (xi >= 0 && yi >= 0 && xi < nRow && yi < nCol && vis[xi][yi] == false && m[xi][yi] == 1) {
                dfs(xi, yi, m, vis);
            }
        }
    }
    private static void bfs(int x,int y,int[][] m,boolean[][] vis)
    {
        vis[x][y] = true;
        int nRow = m.length;
        int nCol = m[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        int[] d = new int[]{0,1,0,-1,0};

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int r = p.a;
            int c = p.b;

            for(int i=0;i<4 ;i++)
            {
                int xi= r+d[i];
                int yi = c+d[i+1];

                if(xi>=0 && yi>=0 && xi<nRow && yi<nCol && vis[xi][yi]==false && m[xi][yi]==1)
                {
                    q.offer(new Pair(xi,yi));
                    vis[xi][yi]=true;
                }
            }
        }

    }

    private static class Pair
    {
        int a,b;
        Pair(int x,int y)
        {
            this.a = x;
            this.b = y;
        }

    }

}
