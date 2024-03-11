package Striver.Arrays.Medium;

 class MajorityElement {
    public static void main(String[] args) {
        // iterate O(n**2)
        // hashmap O(n) space O(nlogn)
        // best -> cancel/ eliminate the distinct elements and the remaining is the majority!!
        int[] a=new int[]{1,4,1,2,3};
        MajorityElement me = new MajorityElement();
        me.optimal(a);
    }
    void optimal(int a[])
    {
        int len = a.length;
        int minOcc= len/2;
        int count = 0;
        int major = Integer.MIN_VALUE;
        for(int i=0;i<len;i++)
        {
            if(count==0)
            {
                major = a[i];
                count++;
            }
          else if(a[i] == major) count++;
            else count--;
        }
        int c=0;
        for(int i=0;i<len ; i++)
        {
            if(a[i]==major) c++;
        }
        if(!(c>minOcc)) major = -1;
        System.out.println(major);
    }

}
