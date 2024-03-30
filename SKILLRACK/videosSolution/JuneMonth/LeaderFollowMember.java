package SKILLRACK.videosSolution.JuneMonth;

import java.util.ArrayList;
import java.util.Arrays;

// LEADER FOLLOWS NO ONE AND ALL MEMBERS FOLLOW THE LEADER!
public class LeaderFollowMember {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> follow = new ArrayList<>();
        int n = 5;
        follow.add(new ArrayList<>(Arrays.asList(1, 2)));
        follow.add(new ArrayList<>(Arrays.asList(2, 3)));
        follow.add(new ArrayList<>(Arrays.asList(1, 3)));
        follow.add(new ArrayList<>(Arrays.asList(4, 3)));
        follow.add(new ArrayList<>(Arrays.asList(5,3)));
        follow.add(new ArrayList<>(Arrays.asList(3,2)));

        // IT IS LIKE A DIRECTED GRAPH,
        // 1 -> 2
        // 2 -> 3
        //.. SO FIND THE NUMBER OF INCOMING AND OUTGOING NODES!!
        LeaderFollowMember obj = new LeaderFollowMember();
        System.out.println(obj.optimal(follow,n));

    }
    private int findLeader(ArrayList<ArrayList<Integer>> follow,int n){
        int len = follow.size();
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        for(ArrayList<Integer> temp : follow)
        {
            indegree[temp.get(1)]++;
            outdegree[temp.get(0)]++;
        }
        System.out.println(Arrays.toString(indegree));
        System.out.println(Arrays.toString(outdegree));
        for(int node=1;node<n+1;node++)
        {
            if(indegree[node]==n-1 && outdegree[node]==0)
                return node;
        }
        return -1;
    }
    private int optimal(ArrayList<ArrayList<Integer>> follow,int n)
    {
        int[] degree = new int[n+1];
        for(ArrayList<Integer> temp : follow)
        {
            degree[temp.get(1)]++; // add the indegree
            degree[temp.get(0)]--; // delete 1 for every outdegree
        }
        System.out.println(Arrays.toString(degree));
        for(int node =1;node<=n;node++)
        {
         if(degree[node]==n-1) return node;
        }
        return -1;
    }
}
