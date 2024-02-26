package Striver.Arrays.Hard;
//229. Majority Element II
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] a= new int[]{1,1,2,1,2,3,2};
        MajorityElement2 me= new MajorityElement2();
        me.optimal(a);
    }
    void bruteSol(int[] a)
    {
        // maximum of 2 elements can occur in the list l
        List<Integer> l  =new ArrayList<>();
        int len = a.length;
        int minOcc = len/3 ;
        int count=0;
        for(int i =0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(a[i]==a[j] && !l.contains(a[j]) ) count++;
            }
            if(count>minOcc) l.add(a[i]);
            count=0;
        }
        int n = l.size();
        for(int i=0;i<n;i++)
        {
            System.out.print(l.get(i)+" ");
        }
    }
    void betterSol(int[] a)
    {
       Map<Integer,Integer> map = new HashMap<>();
       int len = a.length;
       int minOcc = len/3 ;

       for(int i=0;i<len;i++)
       {
           map.put(a[i],map.getOrDefault(a[i],0)+1);
       }

       for(Map.Entry<Integer,Integer> m:map.entrySet())
       {
            if(m.getValue()>minOcc) System.out.print(m.getKey()+" ");
       }
    }
    void optimal(int[] a)
    {
        int count1 = 0;
        int count2 =0;
        int max1=-1,max2=-1;

        int len = a.length;
        int minOcc=len/3;

        for(int i=0;i<len;i++)
        {
            if(count1==0 )
            {
                count1++;
                max1=a[i];
            }
            else if(a[i]==max1) count1++;

           else if(count2==0)
            {
                count2++;
                max2=a[i];
            }
            else if(a[i]==max2 ) count2++;
            else
            {
                count2--;
                count1--;
            }
        }
        System.out.println(max1+" "+max2);



    }


}
