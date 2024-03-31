package SKILLRACK.videosSolution.JulyMonth;

import java.util.Arrays;

public class nQueens {
    public static void main(String[] args) {
        int n = 10;
        int[][] board= new int[n][n];
        System.out.println(QueenPlacement(board,0));
        for(int[] temp:board)
            System.out.println(Arrays.toString(temp));
    }
    private static boolean QueenPlacement(int[][] board,int row)
    {
        if(row == board.length) return true;

        for(int col = 0;col<board[0].length;col++)
        {
            if(isSafeAtPosition(board,row,col))
            {
                board[row][col] = 1;
                if(QueenPlacement(board,row+1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    private static boolean isSafeAtPosition(int[][] board,int x,int y)
    {
        for(int row = 0;row<x;row++)
        {
            if(board[row][y]==1) return false;
        }
        for(int row = x , col = y ; row>=0 && col>=0 ;row--,col--)
        {
            if(board[row][col]==1) return false;
        }
        for(int row = x, col = y; row >= 0 && col <board[0].length; row--, col++)
        {
            if(board[row][col]==1) return false;
        }
        return true;

    }
    private static boolean isSsdafeAtPosition(int[][] board, int x, int y) {
        // Check if there's a queen in the same column
        for (int row = 0; row < x; row++) {
            if (board[row][y] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int row = x, col = y; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int row = x, col = y; row >= 0 && col < board.length; row--, col++) {
            if (board[row][col] == 1)
                return false;
        }
        return true;
    }


}
