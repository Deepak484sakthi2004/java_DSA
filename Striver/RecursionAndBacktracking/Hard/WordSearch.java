package Striver.RecursionAndBacktracking.Hard;

public class WordSearch {

    public static void main(String[] args) {
        String s = "DEEPAK";
        char[][] board = {
                {'D','E','P','A','K'},
                {'E','A','E','K','S'},
                {'E','P','E','S','K'},
                {'P','A','K','E','A'},
                {'A','E','E','P','K'},
        };

        System.out.println(isAvailable(s, board));
    }

    private static boolean isAvailable(String s, char[][] board) {
        int nRow = board.length;
        int nCol = board[0].length;
        boolean[][] vis = new boolean[nRow][nCol];
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (wordSearch(s, board, 0, row, col, vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean wordSearch(String s, char[][] board, int ind, int x, int y, boolean[][] vis) {
        if (ind == s.length()) return true;

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y] || s.charAt(ind) != board[x][y])
            return false;

        vis[x][y] = true;
        int[] d = {0, 1, 0, -1, 0};
        for (int dir = 0; dir < 4; dir++) {
            int xi = x + d[dir];
            int yi = y + d[dir + 1];
            if (wordSearch(s, board, ind + 1, xi, yi, vis))
                return true;
        }
        vis[x][y] = false; // Backtrack
        return false;
    }
}
