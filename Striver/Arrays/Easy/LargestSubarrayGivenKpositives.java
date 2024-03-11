package Striver.Arrays.Easy;

// https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class LargestSubarrayGivenKpositives{
public static void main(String[]args){
        System.out.println(    brute(new int[]{2,1,1,2,1,3,4,5,2,7},4));
        }
        public static int brute(int[] a,int target)
        {
                int max=-1;
                int len = a.length;
                for(int i=0;i<len;i++)
                {
                        for(int j=i;j<len;j++)
                        {
                                int sum=0;
                                for(int k=i;k<j;k++)
                                {
                                        sum+=a[k];
                                }
                        if(sum==target) max = Math.max(max,j-i+1);
                        }
                }


                return max;
        }

        


        }
