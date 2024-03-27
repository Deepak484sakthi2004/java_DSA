package SKILLRACK.videosSolution.MayMonth;

import java.util.ArrayList;
import java.util.Arrays;

public class slidingWindowSum {
    public static void main(String[] args) {
        int[] a = {1, 4, 12, 5, 6, 14, 8, 6, 20, 10};
        int windowSize = 3;
        ArrayList<Integer> out = new ArrayList<>();

       dpApproach(a,windowSize,0,out);
        System.out.println(out);

    }
    private static ArrayList<Integer> naiyeApproach(int[] a,int windowSize)
    {
        int n = a.length;
        ArrayList<Integer> out = new ArrayList<>();

        for(int i=0;i<n-windowSize+1;i++)
        {
            int sum =0;
            for(int j=i;j<i+windowSize;j++)
            {
                sum+=a[j];
            }
            out.add(sum);
        }

        return out;
    }
    private static ArrayList<Integer> includeExclude(int[] a,int windowSize)
        {
        int include,exclude,sum=0;
        //first iteration
        for(int i=0;i<windowSize;i++)
        {
            sum+=a[i];
        }

        exclude = a[0];
        include = a[windowSize];

        ArrayList<Integer> out = new ArrayList<>();
        int n = a.length;
        out.add(sum);

        for(int i=1;i<n-windowSize+1;i++)
        {
            sum = sum+include-exclude;
            out.add(sum);
            if(windowSize+i< n ) include = a[windowSize+i];
            else include = 0;
            exclude  = a[i];
        }
        //System.out.println(out);
            return out;
    }
    private static void dpApproach(int[] a,int windowSize,int pos,ArrayList<Integer> out)
    {
        int n =a.length;
        if(pos ==n-windowSize+1) return;

        int pick=0;
        for(int i=pos;i<windowSize+pos;i++)
        {
            pick+=a[i];
        }
        if(pick!=0) out.add(pick);

        dpApproach(a,windowSize,pos+1,out);

    }
    // the next optimal approach is the include exclude approach!!
}
