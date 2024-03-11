import java.util.Arrays;

// the insertion sort takes an element and places it in a correct position!
// adjustant swapping!
// it right swiftes every element!!

public class Insertion_sort_3 {

    public static void main(String[] args) {

        int[] array = new int[]{12, 3, 0, -21, 121, 87, 7, 10, 1};
        //insertionSort(array);
        recursiveInsertionSort(array,0);
        System.out.println(Arrays.toString(array));

    }
    static void insertionSort(int[] a) {

        int n=a.length;
        for(int i=1;i<n;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(a[j]<a[j-1]) swap(a,j,j-1);
            }
        }
        System.out.println(Arrays.toString(a));

    }

    static void swap(int[] a,int i,int j)
    {
        a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];
    }

    static void recursiveInsertionSort(int[] a,int iter_length)
    {
        int n=a.length;
        if(iter_length==n) return;
        for(int j=iter_length;j>0;j--)
        {
            if(a[j-1]>a[j]) swap(a,j,j-1);
        }
        System.out.println(Arrays.toString(a));

        recursiveInsertionSort(a,iter_length+1);
    }
}
