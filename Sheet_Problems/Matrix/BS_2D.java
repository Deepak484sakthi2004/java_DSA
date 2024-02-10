package Matrix;
import java.util.Arrays;

public class BS_2D {
    public static void main(String[] args) {
        int[][] a=new int[][] { {1,2,3},{4,5,6},{7,10,14},{19,40,50} };

        //System.out.println(searchMatrix(a,9));

    otherWay oW = new otherWay(a,55);
        System.out.println(oW.viewSol());

    }
    static class otherWay
    {
        int[][] data;
        int nRow,nCol,target;

        otherWay(int[][] matrix,int t)
        {
            this.data=matrix;
            this.nRow=matrix.length;
            this.nCol=matrix[0].length;
            this.target=t;
        }
        boolean viewSol()
        {
            // row ---> index/col
            // col ---> index%col
            int start=0;
            int end=nRow*nCol -1;
            while(start<=end)
            {
                int mid = ((start+end)/2);
                int row =mid/nCol;
                int col=mid%nCol;

                if(target == data[row][col]) return true;
                if (target> data[row][col]) start = mid+1;
                else end = mid-1;
            }
            return false;

        }
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int nRow= matrix.length;
        int nCol= matrix[0].length;

        int row= rowCheck(target, matrix);
        if(row==-1) return false;
        System.out.println(row);
        return bSearch(matrix[row],target);

    }
    public static int rowCheck(int t,int[][] m)
    {
        int start=0;
        int nCol= m[0].length - 1;
        int end=m.length-1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;

            // if the target is between the col
            if( t<=m[mid][nCol] && t>= m[mid][0] ) return mid;
            if(t>m[mid][nCol]) start = mid+1;
            else end=mid-1;
        }
        return -1;
    }
    public static boolean bSearch(int[] a, int t)
    {
        int start=0;
        int end=a.length -1;
        while(start<=end)
        {
            int mid=start + (end - start)/2;
            if(t==a[mid]) return true;

            if(t<a[mid]) end = mid-1;

            else start = mid+1;

        }
        return false;

    }
}
