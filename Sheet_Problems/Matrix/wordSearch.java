package Matrix;

public class wordSearch {
    public static void main(String[] args) {
        // Example usage
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ECE";
        System.out.println(exist(board, word));  // Output: true
    }

    public static boolean exist(char[][] board, String word) {
        int nRow = board.length;
        int nCol = board[0].length;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (board[i][j] == word.charAt(0) && recDFS(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean recDFS(char[][] b, String s, int x, int y, int pos) {
        if (pos == s.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= b.length || y >= b[0].length || b[x][y] != s.charAt(pos)) {
            return false;
        }

        char original = b[x][y];
        b[x][y] = '#'; // Mark the current cell as visited

        // Explore in all four directions
        if (recDFS(b, s, x + 1, y, pos + 1) || recDFS(b, s, x - 1, y, pos + 1) ||
                recDFS(b, s, x, y + 1, pos + 1) || recDFS(b, s, x, y - 1, pos + 1)) {
            return true;
        }

        // Restore the original value when backtracking
        b[x][y] = original;
        return false;
    }
}
