package SKILLRACK.videosSolution.MayMonth;

// n - number of steps
// steps, damage - number of input possible steps that he/she can take
// the possible steps , the damages step list

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class climbingDamagedStairs
{
    public static void main(String[] args)
    {
        int totalSteps = 6;
        int[] steps = {2,3};
        List<Integer> damagedSteps = new ArrayList<>();
        damagedSteps.add(6);
        damagedSteps.add(5);

        System.out.println(tabulation(steps,damagedSteps,totalSteps));
    }
    private static int rec(int[] possibleSteps, List<Integer> damagedSteps ,int curStep )
    {
        if(curStep==0) return 1;
        if(curStep<0) return 0;
        int len = possibleSteps.length;

        int out =0;
        for(int possibleStepInd = 0;possibleStepInd < len ; possibleStepInd++)
        {
            if(curStep-possibleSteps[possibleStepInd]>= 0 && !damagedSteps.contains(curStep-possibleSteps[possibleStepInd]))
            {
                out+= rec(possibleSteps,damagedSteps,curStep-possibleSteps[possibleStepInd]);
            }
        }
        return out;
    }

    private static int dpApproach(int[] possileSteps, List<Integer> damagedSteps, int curStep)
    {

        int[] dp = new int[curStep+1];
        Arrays.fill(dp,-1);
        climbingDamagedStairs obj = new climbingDamagedStairs();

        return obj._dpHelper(possileSteps,damagedSteps,curStep,dp);
    }

    private int _dpHelper(int[] possileSteps, List<Integer> damagedSteps, int curStep, int[] dp)
    {
     if(curStep ==0) return 1;
     if(curStep<0) return 0;

     if(dp[curStep]!=-1) return dp[curStep];
     int len = possileSteps.length;
     int result = 0;
     for(int possibleStepInd = 0;possibleStepInd<len;possibleStepInd++)
     {
         int futureStep = curStep - possileSteps[possibleStepInd];
         if(futureStep>=0 && !damagedSteps.contains(futureStep))
         {
             result += _dpHelper(possileSteps,damagedSteps,futureStep,dp);
         }
     }
     return dp[curStep] = result;
    }
    // ------------------------------------------
    private static int tabulation(int[] possileSteps, List<Integer> damagedSteps, int curStep)
    {
        int[] dp = new int[curStep];
        int n = curStep;
        int len = possileSteps.length;
        dp[0] = 1;
        for(int ind =1;ind<n;ind++) {
            for (int possibleStepInd = 0; possibleStepInd < len; possibleStepInd++) {
                int pastStep = ind - possileSteps[possibleStepInd];

                if (pastStep >= 0 && !damagedSteps.contains(pastStep)) {
                    dp[ind] += dp[pastStep];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}