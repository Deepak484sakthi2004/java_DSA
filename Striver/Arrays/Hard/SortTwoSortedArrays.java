package Striver.Arrays.Hard;
import java.util.Arrays;
import java.lang.Math;
public class SortTwoSortedArrays {
    public static void main(String[] args) {
        int[] a= new int[] {1,2,3,4,5};
        int b[] = new int[] {0,3,5,7,9};
        sortTwoArray(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    static void sortTwoArray(int[] a,int[] b)
    {
        int n1=a.length;
        int n2 = b.length;

        int gap = (n1+n1)/2 +(n1+n2)%2;
        int p1=0;
        int p2 = gap;
        int count =0;
        while(gap>0)
        {
            p1=0;
            p2 = p1+gap;
            while(p2<n1+n2) {
                if (p1 >= n1 ) {

                        swap(b, b, p1-n1, p2-n1);

                }
                else if (p2 < n1 && p1<n1) {
                     swap(a, a, p1, p2);

                }

                else {
                    swap(a,b,p1,p2-n1);
                }
                p2++;
                p1++;

            }

            gap = (gap)/2 + (gap)%2;

            if(gap==1) count++;

            if(gap==1&&count>1)
            {break;}

        }
    }
    static void swap(int[] a,int[] b,int p1,int p2)
    {
        if(a[p1]>b[p2])
        {
            a[p1]=a[p1]^b[p2];
            b[p2]=a[p1]^b[p2];
            a[p1]=a[p1]^b[p2];
        }

    }
}

