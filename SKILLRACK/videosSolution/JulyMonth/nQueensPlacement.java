package SKILLRACK.videosSolution.JulyMonth;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class nQueensPlacement {
    public static void main(String[] args) {
        int n = 7;
        int[][] board = new int[n][n];
        board[0][3] = 1;
        board[6][1] = 1;
        boolean allQueenPlaced = queenPlacement(board,n,0);
        if(allQueenPlaced) {
            for (int[] temp : board)
                System.out.println(Arrays.toString(temp));
        }
        else
            System.out.println("all queens cannot be placed!!");

    }
    private static boolean  queenPlacement(int[][] board,int n,int row)
    {
        if(row == board.length) return true;

            for (int col = 0; col < n; col++)
            {
                if(board[row][col]==1)
                {
                    if(queenPlacement(board,n,row+1)) return true;
                }
                if(isSafe(board, row,col))
                {
                    board[row][col] = 1;
                    if(queenPlacement(board,n,row+1)) return true;
                    board[row][col]=0;
                }

            }

        return false;
    }

    private static boolean isSafe(int[][] board, int x, int y)

    {
        // Check if there's a queen in the same column
        for (int row = 0; row < board.length; row++) {
            if (board[row][y] == 1)
                return false;
        }
        for(int col = 0;col<board.length;col++)
        {
            if(board[x][col]==1)
                return false;
        }

        // Check upper left upper diagonal
        for (int row = x, col = y; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1)
                return false;
        }
        // left lower diagnal
        for(int row=x,col=y;row< board.length && col< board.length; row++,col++)
        {
            if(board[row][col]==1) return false;
        }
        // Check upper right diagonal
        for (int row = x, col = y; row >= 0 && col < board.length; row--, col++) {
            if (board[row][col] == 1)
                return false;
        }
        //
        for(int row=x ,col=y ;row< board.length && col >=0 ; col--,row++)
        {
            if(board[row][col]==1) return false;
        }
        return true;
    }
}

