package Striver.RecursionAndBacktracking.Hard;

public class WordSearch {

    public static void main(String[] args) {
        String s = "DEEPAKSAKTHI";
        char[][] board = {
                {'D', 'E', 'P', 'A', 'K'},
                {'E', 'K', 'T', 'K', 'K'},
                {'E', 'A', 'H', 'I', 'V'},
                {'P', 'S', 'K', 'E', 'A'},
                {'A', 'K', 'E', 'P', 'K'},
        };

        System.out.println(isAvailable(s, board));
    }
    private static boolean isAvailable(String s,char[][] board)
    {
        int n = board.length;
        boolean[][] vis = new boolean[n][n];
        for(int row =0 ;row<n;row++)
        {
            for(int col = 0 ;col<n;col++)
            {
                if(s.charAt(0)==board[row][col])
                {
                    if(wordAvailable(s,board,row,col,vis,0)) return true;
                }
            }

        }
        return false;
    }
    private static boolean wordAvailable(String s ,char[][] board,int row,int col,boolean[][] vis,int ind)
    {
        vis[row][col] = true;
        if(ind==s.length()) return true;

        if(board[row][col]!= s.charAt(ind)) return false;

        int d[] ={0,-1,0,1,0};

        for(int dir = 0;dir<4;dir++)
        {
            int xi = row+d[dir];
            int yi = col+d[dir+1];
            if(xi>=0 && yi>=0 && xi<board.length && yi <board[0].length && !vis[xi][yi]) {
                vis[xi][yi] = true;
                if (wordAvailable(s, board, xi, yi, vis, ind + 1))
                    return true;
                vis[xi][yi]=false;
            }
        }

        return false;
    }
}