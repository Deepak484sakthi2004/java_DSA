package SKILLRACK.videosSolution.MayMonth;

import java.util.Arrays;

// n - number of steps
// k - number of input possible steps that he/she can take
// the possible steps
public class stairClimbing {

    public static void main(String[] args) {


        int n = 7;
        int nSteps = 2;
        int[] steps = new int[nSteps];

//        for (int i = 0; i < nSteps; i++) {
//
//        } set the user input!!
        steps[0] = 2;
        steps[1] = 3;
        System.out.println(tabulation(steps,n));
    }
    private static int rec(int[] steps, int n)
    {
        if(n==0) return 1;

        int len = steps.length;
        int numberCount=0;
        for(int i=0;i<len;i++)
        {
            if(n-steps[i]>=0)
            {
                numberCount+=rec(steps,n-steps[i]);
            }
        }

        return numberCount;
    }
    private static  int dpApproach(int[] steps,int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return dpSolution(dp,steps,n);

    }
    private static int dpSolution(int[] dp,int[] a,int n)
    {
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int len =a.length;

        int numCount = 0;
        for(int i=0;i<len;i++)
        {
            if(n-a[i]>=0)
            {
                numCount+=dpSolution(dp,a,n-a[i]);
            }
        }
        return dp[n] = numCount;
    }
    //------------------------------

    private static int tabulation(int[] steps,int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 1;
        int len = steps.length;

        for(int i=1;i<=n;i++)
        {
            for(int step=0;step<len;step++)
            {
                if(i-steps[step]>=0)
                {
                    dp[i] += dp[i-steps[step]];
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
