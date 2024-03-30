package SKILLRACK.videosSolution.JuneMonth;

import java.util.Arrays;

public class NumberOfPathFromTopLeftToBottomRight {
    public static void main(String[] args) {
        int[][] graph =
                {
                        {1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1}
                };
        // 0 is not path!
        System.out.println(recBottomRight(graph, 0, 0, graph.length - 1, graph[0].length - 1));
    }
    private static int rec(int[][] graph, int startX, int startY, int endX, int endY)
    {
        boolean[][] vis = new boolean[graph.length][graph[0].length];
      return  dpApproach(graph, 0, 0, graph.length - 1, graph[0].length - 1);
    }

    private static int recAllDirection(int[][] graph, int startX, int startY, int endX, int endY, boolean[][] vis) {
        if (startX == endX && startY == endY)
            return 1; // Reached the destination, return 1 for one valid path
        vis[startX][startY] = true;
        int nRow = graph.length;
        int nCol = graph[0].length;
        int[] d = {1, 0, -1, 0, 1};
        int nWays = 0;
        for (int directions = 0; directions < 4; directions++) { // Loop up to 4, not 5
            int curX = startX + d[directions];
            int curY = startY + d[directions + 1];
            if (curX >= 0 && curY >= 0 && curX < nRow && curY < nCol && graph[curX][curY] == 1 && !vis[curX][curY]) {
                nWays += recAllDirection(graph, curX, curY, endX, endY, vis);
            }
        }
        vis[startX][startY] = false; // Unmark the cell before returning
        return nWays;
    }
// -----------------------------------------------------------------------------------------------------------------------------
    private static int recBottomRight(int[][] graph, int startX, int startY, int endX, int endY)
    {
        if(startX==endX && startY==endY) return 1;
        int nRow = graph.length;
        int nCol = graph[0].length;

        int rightMovement  =0;
        if(startX+1<nRow && graph[startX+1][startY]!=0 )
            rightMovement += recBottomRight(graph,startX+1,startY,endX,endY);

        int downMovement = 0;
        if(startY+1<nCol && graph[startX][startY+1]!=0)
            downMovement += recBottomRight(graph,startX,startY+1,endX,endY);

        return rightMovement+downMovement;

    }

    private static int dpApproach(int[][] graph, int startX, int startY, int endX, int endY)
    {
        int[][] dp = new int[graph.length+1][graph[0].length+1];
        for(int[] temp :dp)
            Arrays.fill(temp,-1);
        return dpSolution(graph, startX, startY, endX, endY, dp);
    }
    private static int dpSolution(int[][] graph, int startX, int startY, int endX, int endY,int[][] dp)
    {
        if(startX==endX && startY==endY) return 1;
        if(dp[startX][startY]!=-1) return dp[startX][startY];
        int nRow = graph.length;
        int nCol = graph[0].length;

        int rightMovement  =0;
        if(startX+1<nRow && graph[startX+1][startY]!=0 )
            rightMovement += recBottomRight(graph,startX+1,startY,endX,endY);

        int downMovement = 0;
        if(startY+1<nCol && graph[startX][startY+1]!=0)
            downMovement += recBottomRight(graph,startX,startY+1,endX,endY);

        return dp[startX][startY] = rightMovement+downMovement;
    }
    // ---------------------------
    private static int tabulation(int[][] graph, int startX, int startY, int endX, int endY)
        {
            int[][] dp = new int[graph.length+1][graph[0].length+1];

            dp[endX][endY] =1;
            for(int curRow = endX;curRow>=0 ;curRow++)
            {
             for(int curCol = endY;curCol>=0;curCol++)
             {
                 if(graph[curRow][curCol]!=0)
                 {
                     if(curRow+1<endX) dp[curRow][curCol] +=dp[curRow+1][curCol];
                     if(curCol+1<endY) dp[curRow][curCol]+=dp[curRow][curCol+1];
                 }
                 else{
                     dp[curRow][curCol]=0;
                 }
             }
            }

            return dp[startX][startY];
        }


}
