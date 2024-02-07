
import java.util.ArrayList;
import java.util.Arrays;

class mergeSort_4
{
    public static void main(String[] args) {
        int[] arr = new int[]{343, -2, 67, 55, 90, 12, 3, 0, -21, 121, 87, 7, 10, 1};
        divide(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void divide(int[] a,int low,int high )
    {
        if(high>low)
        {
            int mid =(high + low)/2;
            divide(a,low,mid);
            divide(a,mid+1,high);

            conquer(a,low,mid,high);
        }
    }

    static void conquer(int[] a,int l,int m,int h)
    {
        ArrayList<Integer> list=new ArrayList<>();
        int p1=l;
        int p2= m+1;
        while(p1<=m && p2<=h)
        {
            if(a[p1]>a[p2])
            {
                list.add(a[p2]);
                p2++;
            }
            else {
                list.add(a[p1]);
                p1++;
            }
        }
        while(p1<=m) list.add(a[p1++]);
        while(p2<=h) list.add(a[p2++]);

        int pos=0;
        int ind=l;
        for(;ind<=h;ind++)
        {
          a[ind]=list.get(pos++);
        }

    }
}