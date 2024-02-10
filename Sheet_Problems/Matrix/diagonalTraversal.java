package Matrix;

public class diagonalTraversal {

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = findDiagonalOrder(matrix);

//        // Print the result array
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int nRow = mat.length;
        int nCol = mat[0].length;

        int[] res = new int[nRow * nCol];
        int ind = 0;
        int rx = 0;
        int cx = 0;
        res[ind++] = mat[rx][cx];

        boolean going_up = true;
        while (ind < nRow * nCol) {
            if (going_up) {
                rx--;
                cx++; // it is going up diagonally
                System.out.println(rx+"  "+cx);
                boolean checkin = checkBoundary(mat, rx, cx);
                if (!checkin) {
                    handleOut(going_up, nRow, nCol, rx, cx);
                } else {
                    res[ind++] = mat[rx][cx];
                }
                going_up = !going_up;
            }
            else
            {
                rx++;
                cx--; // it is going down diagonally
                boolean checkin = checkBoundary(mat, rx, cx);
                if (!checkin) {
                    handleOut(going_up, nRow, nCol, rx, cx);
                } else {
                    res[ind++] = mat[rx][cx];
                }
                going_up = !going_up;
            }
        }

        return res;
    }

    public static void handleOut(boolean goingUp, int nRow, int nCol, int rx, int cx) {
        if (goingUp) {
            if (rx < 0 && cx < nCol) {
                rx = 0;
            } else if (rx >= nRow) {
                rx = nRow - 1;
                cx += 2;
            }
        } else {
            if (cx < 0 && rx < nRow) {
                cx = 0;
            } else if (cx >= nCol) {
                cx = nCol - 1;
                rx += 2;
            }
        }
    }

    public static boolean checkBoundary(int[][] a, int x, int y) {
        int r = a.length;
        int c = a[0].length;
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
