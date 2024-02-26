package Striver.Arrays.Hard;
import java.util.Arrays;
import java.util.Scanner;

//Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
//Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
//Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        System.out.println("for printing the nth row -> 1");
        System.out.println("for printing the element in the nth row and mth col -> 2");
        System.out.println("for printing the entire n rows -> 3");
        int n =z.nextInt();
        PascalTriangle pt=new PascalTriangle();
        pt.sw(n);

    }
    void sw(int n)
    {
        Scanner z=new Scanner(System.in);

        switch(n)
        {
            case 1:{
                nthRow nr = new nthRow();
                int m= z.nextInt();
                nr.nth(m);
                break;
            }
            case 2:
            {
                int m= z.nextInt();
                int nCol = z.nextInt();
                nmElement nm = new nmElement();
                nm.nele(m,nCol);
                break;
            }
            case 3:
            {
                int nRow = z.nextInt();
                triangle t=new triangle();
                t.print(nRow);
                break;
            }
            default:
                System.out.println("invalid input");
                return ;
        }
    }
    class nthRow
    {
        // print the nth row in the pascal triangle like 1 4 6 4 1
        void nth(int n)
        {
         nthRow ob = new nthRow();
         ob.better(n);
        }
        void better(int n)
        {
        // calling the nCr every time
            for(int i=0;i<n;i++)
            {
                call(n,i);
            }
        }
        static void call(int n,int r)
        {
            int res = 1;

            for(int i=1;i<=r;i++) {
                res = res * (n - i);
                res = res / i;
            }
            System.out.print(res+" ");
        }
        void optimal(int n)
        {
            int res =1 ;
            System.out.print(res+" ");
            int m=n;
            for(int i=1;i<n;i++)
            {
                res = res*(m-i);
                res = res / i ;
                System.out.print(res+" ");
            }
        }
    }

    class nmElement
    {
        void nele(int r,int c)
        {
        int res = 1;
        for(int i=1;i<c;i++)
        {
            res  = res*(r- i);
            res = res/i;
        }
            System.out.println(res);
        }
    }

    class triangle
    {
        void print(int n)
        {
        triangle t = new triangle();
        t.optimal(n);
        }
        void optimal(int n)
        {
            int res =1 ;
            for(int i=1;i<=n;i++)
            {
                callTriangle(i,i-1);
                System.out.println();
            }
        }
        static void callTriangle(int n,int r)
        {
            int res = 1;
            System.out.print(res+" ");
            for(int i=1;i<=r;i++)
            {
                res = res*(n-i);
                res = res/i;
                System.out.print(res+" ");
            }
        }
        void better(int n)
        {
            // runs with O(n*r*n);
            // call the row
            // the row calls individual element finding
        }

    }
}
