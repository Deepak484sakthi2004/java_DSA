//package SKILLRACK;
//
//// The program must accept the stock prices on N days as the input.
//// A person can buy a stock on a particular day and he can sell it once on any other given day.
//// He can not buy and sell on the same day. The program must print the maximum possible profit P
//// that can be obtained by buying and selling the stocks multiple times as the output.
//// Note: The person can buy only one stock at a time and the person can buy another stock only
//// after selling it.
//
//
//// Boundary Condition(s): 2 <= N <= 10^5
//// 1 <= Each integer value <= 10^5
////
//// Input Format: The first line contains N.
//// The second line contains N integers separated by a space.
////
//// Output Format: The first line contains P.
////
//// Example Input/Output 1: Input: 10 5 8 10 12 9 6 14 21 15 10
//// Output: 22
//// Explanation: Here N = 7. The maximum profit is obtained by buying & selling the
//// stocks in the following ways. On buying the stock on the 1st day and
//// selling it on the 4th day can earn the profit 7 (12 - 5 = 7). On buying
//// the stock on the 6th day and selling it on the 8th day can earn
//// the profit 15 (21 - 6 = 15). So the total profit is 22 (7 + 15).
//public class StockBuySellMultipleTimes {
//
//    // user can hold only one stock
//    public static void main(String[] args) {
//        int[] a=new int[]{1,2,3,1,20,30,10,5,6};
//        System.out.println(dp(a,0,0));
//    }
//
//    public static int dp(int[] a,int n,int max)
//    {
//        if(n>=a.length) return 0;
//
//            return dp(a,n+1,)
//    }
//}
