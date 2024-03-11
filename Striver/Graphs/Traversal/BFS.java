package Striver.Graphs.Traversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class BFS
{
static class traversalImplement
{
    void Adjmatrix(List<List<Integer>> adj,int startNode)
    {
      Queue<Integer> q = new LinkedList<>();
      q.offer(startNode);
      boolean[] visited = new boolean[adj.size()];
       // System.out.println(q.peek());
        visited[startNode] = true;
      while(!q.isEmpty())
      {
          int curNode = q.poll();
          System.out.println(curNode);

          for(int n:adj.get(curNode))
          {
              if(!visited[n])
              {
                  q.offer(n);
                  visited[n] = true;
              }
          }
      }

    }
}

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        Scanner z=new Scanner(System.in);
        int nNodes = z.nextInt();
        for(int i=0;i<nNodes;i++)
        {
          List<Integer> inner = new ArrayList<>();
          int n = z.nextInt();
          while(n>=0)
          {
              inner.add(n);
              n = z.nextInt();
          }
          l.add(inner);
        }
        traversalImplement ti = new traversalImplement();
        ti.Adjmatrix(l,0);

    }

}