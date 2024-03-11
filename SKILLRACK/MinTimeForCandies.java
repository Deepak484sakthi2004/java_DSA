package SKILLRACK;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Iterator;

class MinTimeForCandies
{
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        int nTest = z.nextInt();

        for(int i=0;i<nTest;i++)
        {
            int Size = z.nextInt();
            int[] a = new int[Size];
            for(int n=0;n<Size;n++)
            {
                a[n]=z.nextInt();
            }
            System.out.println( logic(a));
        }
    }
    public static int logic(int[] a)
    {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int len = a.length;
        for(int i=0;i<len;i++)
        {
            pq.add(a[i]);
        }
int sum=0;
while(pq.size()>1)
{
int x=pq.poll();
int y=pq.poll();
sum+=x+y;
pq.add(x+y);

}
        return sum;
}
}