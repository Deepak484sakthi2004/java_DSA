import java.util.Arrays;

/*
The bubble sort is different from the selection sort
bubble sort pushes the maximum to the last
whereas selection sort pushes the minimum to the front!
* */
// the time complexity is O(n^2) and space O(1);

public class Bubble_sort_2 {
    public static void main(String[] args) {
        Bubble_sort_2 bs = new Bubble_sort_2();

        int[] array = new int[]{12, 3, 0, -21, 121, 87, 7, 10, 1};

        bs.bubbleSortRecursion(array,array.length-1);
        System.out.println(Arrays.toString(array));
    }


    // this is wrong , it is not pushing the max element to the last,
    // IT IS PUSHING THE LAST ELEMENT TO THE LAST BY ADJACENT SWAPPING!!

    // iterate from the end, and push the max to the end and pointer -1

    void bubbleSort(int[] a)
    {
        int n=a.length;
        boolean isSwap=false;
        for(int i=n-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j]>a[j+1]) {
                    swap(a,j+1,j);
                    isSwap=true;
                }
            }
            if(!isSwap) return;
        }
    }

    static void swap(int[] a,int i,int j)
    {
        a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];
    }

    void bubbleSortRecursion(int[] a,int iter_length)
    {
        if(iter_length==0)return;
        boolean isSwap=false;
        for(int i=0;i<iter_length;i++)
        {
            if(a[i]>a[i+1]) {
                swap(a,i,i+1);
                isSwap=true;
            }
        }
        if(!isSwap) return;
        bubbleSortRecursion(a,iter_length-1);
    }


}
