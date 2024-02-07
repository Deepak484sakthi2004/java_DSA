import java.util.Arrays;

/*
step 1: the pointer is pointed at the 0th position, now select the min and swap the pointer position with the min element postion
step 2: move the pointer by 1
step 3: repeat step 1 and 2

 */

public class selection_sort_1 {
    public static void main(String[] args) {
        // class object creation for a static method, selection_sort
        selection_sort_1 ss=new selection_sort_1();
        int[] array=new int[]{12,3,3,0,121,-12,9,234,1,12};
        int[] sorted_array =ss.selection_sort(array);
        System.out.println("the sorted array is: "+Arrays.toString(sorted_array));
// the time compexity of the code is O(n^2) and O(1) space complexity!!
    }

    int[] selection_sort(int[] a)
    {
        // code for selection sort
        int pointer=0;
        int n=a.length;
        while(pointer<n-1)
        {
            // find the minimum
            int min=pointer;
            for(int i=pointer;i<n;i++)
            {
                if(a[min]>a[i]) min=i;
            }
            //swap the minimum and pointer position
            swap(a,min,pointer);
            pointer++;
        }
        return a;
    }
    static void swap(int[] a,int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
