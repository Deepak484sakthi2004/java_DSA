package DialyLeetCode;

public class LongestIncreasingSubsequence {
    public static class solution
    {
        public static int lengthOfLIS(int[] nums) {

           return dp(nums,0,Integer.MIN_VALUE);
        }

        public static int dp(int[] a,int index,int cur)
        {
            int len = a.length - 1;
            if (index == len) return 1;
            System.out.println("COUNT "+" VALUE "+cur+" POSITION "+index);

            int notInclude =  dp(a,index+1,cur);
            System.out.println("COUNT "+" VALUE "+cur+" POSITION "+index);

            int include= 0;
            if(a[index]>cur)
            {
                System.out.println("COUNT "+" VALUE "+cur+" POSITION "+index);

                include = 1+ dp(a,index+1,a[index]);
                System.out.println("COUNT "+" VALUE "+cur+" POSITION "+index);

            }
            System.out.println("COUNT "+" VALUE "+cur+" POSITION "+index);
            System.out.println("==========================");
            return Math.max(notInclude,include);
        }
        // let us assume there is a list 2,5,4,6,9,7,8,11,10
        //
        public static int dp_take_leave(int[] a, int pos, int count) {
            int len = a.length - 1;

            if (pos == len) {
                return 1;
            }

            int takeCurrent = dp_take_leave(a, pos + 1, count + 1);
            int skipCurrent = dp_take_leave(a, pos + 1, count);
            return takeCurrent + skipCurrent;
        }


    }

    public static void main(String[] args) {
        System.out.println(solution.lengthOfLIS(new int[]{1,2,3,4}));
    }
}
