import java.util.Arrays;

class min
{
    public static void main(String[] args) {
        int[] a={23,1,32,0,-1,23,11,-21,0};
        min m=new min();
        m.selection_sort(a);
        System.out.println(Arrays.toString(a));
    }

    void selection_sort(int[] a)
    {
        min m=new min();
        int n=a.length;
        int min_index=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                min_index=m.min(a,i);
            }
            m.swap(a,i,min_index);
        }
    }
    int min(int[] a,int i)
    {
        int m=0;
        for(int x=i;x<a.length;x++)
        {
            m = (a[m]>a[x])? x:m;
        }
        return m;
    }

    void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void sort(int[] a)
    {
        min m=new min();
        int len=a.length;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(a[j]<a[i]) m.swap(a,i,j);

            }
        }
    }
}