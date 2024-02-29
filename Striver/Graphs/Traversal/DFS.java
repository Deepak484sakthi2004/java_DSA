package Striver.Graphs.Traversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
static class Implement
{
    void dfs(List<List<Integer>> adj, int startNode)
    {
        boolean[] visited = new boolean[adj.size()];
        visited[startNode] = true;
        System.out.println(startNode);
        for(int node : adj.get(startNode))
        {
            if(!visited[node])
            {
                dfs(adj,node);
                System.out.println(node);
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
        BFS.traversalImplement ti = new BFS.traversalImplement();
        ti.Adjmatrix(l,0);

    }
}
