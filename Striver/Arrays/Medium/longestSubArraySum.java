package Striver.Arrays.Medium;

import java.lang.Math;

 class longSubArraySum {
    public static void main(String[] args) {
      int[] a = new int[]{1,2,3,6,5,2,1,1,1,4,3,2,1};
      longSubArraySum lSum = new longSubArraySum();
      System.out.println(lSum.brute(a,3));
    }

    private int brute(int[] a,int sum)
    {
      int nLen = 0;
      // generate subarray with sum
      int len = a.length;
      for(int i=0;i<len;i++)
      {
         int add = 0;
         for(int j=i;j<len;j++)
         {
            add+=a[j];

            if(add == sum) {
               nLen = Math.max(nLen, j-i+1);
               System.out.println(i+" "+j+" "+nLen);
            }
         }
      }
      return nLen;
    }

   }