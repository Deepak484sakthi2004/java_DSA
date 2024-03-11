package Matrix;

public class magicSquareGrid_840 {
    public static void main(String[] args) {

        int grid[][] = new int[][] { {4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {

        int nRow= grid.length;
        int nCol= grid[0].length;
        int count=0;
        for(int i=1;i<nRow;i++)
        {
            for(int j=1;j<nCol;j++)
            {
                // diagonal
                int a = grid[i-1][j-1];
                int b = grid[i][j];
                int c = grid[i+1][j+1];

                int a1=grid[i+1][j+1];
                int c1=grid[i-1][j-1];

                //row col check
                int row1=grid[i-1][j];
                int row2 =grid[i+1][j];

                int col1=grid[i][j-1];
                int col2=grid[i][j+1];



                if( (a+b+c == a1+b+c1) && (row1+b+row2 == col1+b+col2))  count++;
            }
        }
        return count;
    }
}
