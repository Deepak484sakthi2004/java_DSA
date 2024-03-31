package SKILLRACK.videosSolution.JulyMonth;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostBetweenTwoVertices {
    public static void main(String[] args) {
        int[][] graph =
                {
                        {0, 10, 0, 0, 27},
                        {15, 0, 0, 12, 0},
                        {0, 2, 0, 1, 1},
                        {0, 0, 4, 5, 1},
                        {0,1,1,1,0}
                };
        int nVertices = graph.length;
        int source = 0;
        int destination = 4;
        boolean[] vis = new boolean[nVertices];
        path(graph, source, destination, vis);

        int cost = minimumCost(graph, source, destination, vis);
        System.out.println(cost);
    }

    private static void path(int[][] graph, int source,int destination, boolean[] vis)
    {
        List<Integer> paths = new ArrayList<>();
        pathFinder(graph, source, destination, vis,paths);
    }

    private static void pathFinder(int[][] graph, int source,int destination, boolean[] vis,List<Integer> paths)
    {
        if(source == destination)
        {
            //paths.add(destination);
            System.out.println(paths);
            return;
        }
        if(vis[source]) return;
        vis[source]=true;

        for(int nextNode = 0 ;nextNode<graph[0].length;nextNode++)
        {
            if(graph[source][nextNode]>0)
            {
                paths.add(source);
                pathFinder(graph,nextNode,destination,vis,paths);
                paths.remove(paths.size()-1);
            }
        }
        vis[source]=false;

    }

    private static int minimumCost(int[][] graph, int source,int destination, boolean[] vis)
    {
        if(source==destination) return 0;
        if(vis[source]) return -1;
        vis[source] = true;

        int minCost = Integer.MAX_VALUE;
        for(int nextNode=0;nextNode<graph[0].length;nextNode++)
        {
            if(graph[source][nextNode]>0)
            {
                if(minimumCost(graph,nextNode,destination,vis)!=-1)
                {
                    int min = graph[source][nextNode] + minimumCost(graph,nextNode,destination,vis);
                    minCost = Math.min(minCost,min);
                }
            }
        }
        vis[source]=false;
        return (minCost==Integer.MAX_VALUE)?-1:minCost;
    }


}
