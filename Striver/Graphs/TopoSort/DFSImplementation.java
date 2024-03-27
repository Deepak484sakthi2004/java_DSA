package Striver.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSImplementation {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        l.add(new ArrayList<>());
        l.add(new ArrayList<>());
        l.add(new ArrayList<>());
        l.add(new ArrayList<>());
        l.add(new ArrayList<>());

        l.get(0).add(5);
        l.get(0).add(1);

        l.get(1).add(2);

        l.get(3).add(2);

        l.get(4).add(1);
        l.get(4).add(3);

        l.get(5).add(4);

       // print(l);
        Stack<Integer> st = new Stack<>();
        int len = l.size();
        boolean[] vis = new boolean[len];
        out:
        for(int i = 0; i < len; i++) {
            if (!vis[i]) {
          //      topoSortDFS(l, i, st, vis);
                break out;
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    // a queue and a indegree array !!
    private static void topoSortBFS(ArrayList<ArrayList<Integer>> l)
    {
        int len = l.size();
        int[] indegree =  new int[len];

        for(ArrayList<Integer> in :l)
        {
            for(int n :in)
            {
                indegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<len;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }

        while(!q.isEmpty())
        {
            int ele = q.poll();
            System.out.print(ele+" ");

           // for(int i : l)
        }
    }

    private static void topoSortDFS(ArrayList<ArrayList<Integer>> l, int ind, Stack<Integer> st, boolean[] vis) {
        vis[ind] = true; // Mark the current node as visited
        for (int neighbor : l.get(ind)) { // Iterate over the neighbors of the current node
            if (!vis[neighbor]) {
                topoSortDFS(l, neighbor, st, vis);
            }
        }
        st.push(ind); // Push the current node onto the stack after visiting all its neighbors
    }

    private static void print(ArrayList<ArrayList<Integer>> l) {
        for (ArrayList<Integer> sublist : l) {
            System.out.println(sublist);
        }
    }
}
