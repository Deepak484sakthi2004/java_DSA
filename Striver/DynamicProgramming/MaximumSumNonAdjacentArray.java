package Striver.DynamicProgramming;
import java.lang.Math;
import java.util.Arrays;


public class MaximumSumNonAdjacentArray {
    public static void main(String[] args) {
        int[] a = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int len = a.length-1;

        MaximumSumNonAdjacentArray ob = new MaximumSumNonAdjacentArray();

        int[] dp = new int[len+1];
        for(int i=0;i<len+1;i++)
        {
            dp[i]=-1;
        }

//        System.out.println(ob.memo(a,len,dp));
//        int res = ob.tab(a,dp);
//        System.out.println(res);
        System.out.println(ob.opt(a));

    }

    private int method(int[] a,int pos)
    {
        if(pos==0) return a[pos];
        if(pos<0) return 0;

        int pick = a[pos] + method(a,pos-2);
        int notPick = method(a,pos-1);

        return Math.max(pick,notPick);
    }
    private int memo(int[] a,int pos,int[] dp)
    {
        if(pos ==0 ) return a[pos];
        if(pos<0) return 0;

        if(dp[pos]!=-1) return dp[pos];

        int pick= a[pos] + memo(a,pos-2,dp);
        int notPick = memo(a,pos-1,dp);

        dp[pos] = Math.max(pick,notPick);

        return dp[pos];
    }

    private int tab(int[] a ,int[] dp)
    {
        dp[0] = a[0];
        int len = a.length;
        for(int i=1;i<len;i++)
        {
            int pick = a[i];

            if(i>1)
            {
                pick+=dp[i-2];
            }
            int notPick = dp[i-1];

            dp[i]= Math.max(pick,notPick);
        }
        return dp[len-1];

    }
    private int opt(int[] a)
    {
        int prev = a[0];
        int prev1=0;

        int len = a.length;

        for(int i=1;i<len;i++)
        {
            int pick = a[i];
            if(i>1) pick+=prev1;

            int notPick = prev;

            int cur = Math.max(pick,notPick);
            prev1= prev;
            prev = cur;
        }
        return prev;
    }
}
