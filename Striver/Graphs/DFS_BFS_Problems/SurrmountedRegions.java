package Striver.Graphs.DFS_BFS_Problems;
import java.util.Arrays;

public class SurrmountedRegions {
    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {
                        {'o','x','x','x','o'},
                        {'x','o','x','o','o'},
                        {'x','o','o','x','x'},
                        {'x','o','x','o','o'},
                        {'x','x','o','o','o'},
                        {'o','o','o','x','o'},
                };
        int nRow=matrix.length;
        int nCol = matrix[0].length ;
        boolean[][] vis = new boolean[nRow][nCol];

        int[] d =new int[]{0,-1,0,1,0};
        // check through the 1 and nCol columns

        for(int i=0;i<nRow;i++)
        {
            if(matrix[i][0]=='o' && vis[i][0]==false)
            {
                dfs(i,0,vis,matrix,d);
            }
            if(matrix[i][nCol-1]=='o' && vis[i][nCol-1]==false)
            {
                dfs(i,nCol-1,vis,matrix,d);
            }
        }
// for the first and last row
        for(int i=0;i<nCol;i++)
        {
            if(matrix[0][i]=='o' && vis[0][i]==false)
            {
                dfs(0,i,vis,matrix,d);
            }
            if(matrix[nRow-1][i]=='o' && vis[nRow-1][i]==false)
            {
                dfs(nCol-1,i,vis,matrix,d);
            }
        }
        System.out.println("before ");
        for( char[] i: matrix)
        {
            System.out.println(Arrays.toString(i));
        }
        //  changing the non visited o's to x
        for(int i=0;i<nRow;i++)
        {
            for(int j=0;j<nCol ; j++)
            {
                if(matrix[i][j]=='o' && vis[i][j]==false)
                {
                    vis[i][j] = true;
                    matrix[i][j] = 'x';
                }
            }
        }
        System.out.println("after dfs ");

        for( char[] i: matrix)
        {
            System.out.println(Arrays.toString(i));
        }
    }

    private static void dfs(int x,int y,boolean[][] vis,char[][] m,int[] d)
    {
        vis[x][y] = true;
        int nRow = m.length;
        int nCol = m[0].length;

        for(int i=0;i<4;i++)
        {
            int xi= x+d[i];
            int yi = y+d[i+1];

            if(xi>=0 && yi>=0 && xi<nRow && yi<nCol && vis[xi][yi]==false && m[xi][yi]=='o')
            {
                dfs(xi,yi,vis,m,d);
            }
        }


    }

}
