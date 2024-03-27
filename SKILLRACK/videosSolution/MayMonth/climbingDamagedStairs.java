package SKILLRACK.videosSolution.MayMonth;

// n - number of steps
// steps, damage - number of input possible steps that he/she can take
// the possible steps , the damages step list

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class climbingDamagedStairs {
    public static void main(String[] args) {
        int totalSteps = 5;
        int[] steps = {2,3};
        List<Integer> damagedSteps = new ArrayList<>();
        damagedSteps.add(2);
        //damagedSteps.add(5);

        System.out.println(tabulation(steps,damagedSteps,totalSteps));
    }
    private static int rec(int[] steps, List<Integer>damage,int n)
    {
        if(n<0) return 0;
        if(n==0) return 1;
        int countNumber = 0;
        int len = steps.length;
        for(int i=0;i<len;i++)
        {
            if(n-steps[i]>=0)
            {
                if(!damage.contains(n-steps[i]))
                    countNumber+=rec(steps,damage,n-steps[i]);
            }
        }
        return countNumber;
    }

    private static int dpApproach(int[] steps, List<Integer>damage,int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dp(steps,damage,n,dp);
    }

    private static  int dp(int[] steps, List<Integer>damage,int n,int[] dp)
    {
        // the code is still wrong, check the skillrack vdo and do it correctly!!!1
        NOTE IT
    }
    private static int tabulation(int[] steps, List<Integer>damage,int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int len = steps.length;
        for(int step=1;step<=n;step++)
        {
            for(int possibleStepInd=0;possibleStepInd<len;possibleStepInd++)
            {
                if(step - steps[possibleStepInd]>=0)
                {
                    if(!damage.contains(step-steps[possibleStepInd]))
                        dp[step] +=dp[step-steps[possibleStepInd]];

                }

            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
