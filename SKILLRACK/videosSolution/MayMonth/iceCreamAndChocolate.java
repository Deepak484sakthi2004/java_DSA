package SKILLRACK.videosSolution.MayMonth;

import java.util.Arrays;

// no two consective days eating icecream
public class iceCreamAndChocolate {
    public static void main(String[] args) {
        int days = 14;

        int totalPossibility = (int) Math.pow(2,5);

        //System.out.println(totalPossibility - continousIceCream(days,0)+1)
        int[] dp  = new int[days+1];
        Arrays.fill(dp,-1);

        System.out.println(continousIceCream(days,days,dp));
        //System.out.println(tabulation(days));
       // System.out.println(optimal(days));
    }

    private static int continousIceCream(int days,int day,int[] dp)
    {
        if(day ==0) return 1;
        if(day==1) return 2;
        if(dp[day]!=-1) return dp[day];
            int pickIceCream = continousIceCream(days,day-2,dp);
        int notPickIceCream = continousIceCream(days,day-1,dp);
        return dp[day]=pickIceCream+notPickIceCream;
    }
    private static int tabulation(int n)
    {
        int[] days = new int[n+1];
        days[0] = 1;
        days[1] = 2;
        for(int i=2;i<=n;i++)
        {
            days[i] = days[i-2]+days[i-1];
        }
        return days[n];
    }

    private static int optimal(int n)
    {
        int prev = 1;
        int cur = 2;
        for(int i=1;i<n+1;i++)
        {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


}
























