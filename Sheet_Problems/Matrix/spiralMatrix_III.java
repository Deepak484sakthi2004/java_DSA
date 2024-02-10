import java.util.ArrayList;
import java.util.List;

class spiralMatrix_III {

    public static void main(String[] args) {

      int[][] res=  spiralMatrixIII(3,4,1,2);
      for(int[] i:res)
      {
          for(int j:i)
          {
              System.out.print(j+" ");
          }
          System.out.println();
      }

    }
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int directionX[] = new int[]{0, 1, 0, -1};
        int directionY[] = new int[]{1, 0, -1, 0};

        int nRow = rows;
        int nCol = cols;
        int x = rStart;
        int y = cStart;

        List<int[]> result = new ArrayList<>();
        int[][] visited = new int[nRow * nCol][2];

        int ind = 0;
        visited[ind++] = new int[]{x, y};
        int pos = 0;
        int d = 1;

        while (ind < nRow * nCol) {
            for (int k = 0; k < 2; k++)
            {
                for (int i = 0; i < d; i++)
                {
                    x += directionX[pos];
                    y += directionY[pos];
                    if (x < nRow && x >= 0 && y < nCol && y >= 0) {
                        visited[ind++] = new int[]{x, y};
                    }
                }
                pos = (pos + 1) % 4;
            }
            d++;
        }

        return visited;
    }
}
