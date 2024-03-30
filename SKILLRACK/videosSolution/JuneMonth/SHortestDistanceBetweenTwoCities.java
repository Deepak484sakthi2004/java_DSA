package SKILLRACK.videosSolution.JuneMonth;

import java.util.LinkedList;
import java.util.Queue;

// given(directed graph) from, to, distance; -> find the shortest distance btwn two given cities;
public class SHortestDistanceBetweenTwoCities {
    public static void main(String[] args) {
        int nNodes = 6;
        int[][] graph =
        {
                {0,0,0,4,0,10}, //0
                {4,0,0,0,0,0},  // 1
                {2,0,0,0,0,1},  // 2
                {0,0,0,0,3,4},  // 3
                {7,0,0,2,0,0},  // 4
                {0,11,0,0,0,0}, // 5

        };
        int startCity = 1;
        int endCity = 6;
        boolean[] vis = new boolean[nNodes];
        SHortestDistanceBetweenTwoCities obj = new SHortestDistanceBetweenTwoCities();
        //System.out.println(obj.fastestRoute(graph,startCity-1,endCity-1,nNodes));
        System.out.println(obj.rec(graph,startCity-1,endCity-1,nNodes,0,vis));
    }
    private int rec(int[][] graph,int startCity,int endCity,int nCities,int distance,boolean[] vis)
    {
        if(startCity==endCity) return distance;

        vis[startCity]=true;
        int min = Integer.MAX_VALUE;
        for(int nextCity = 0;nextCity<nCities;nextCity++)
        {
            if(graph[startCity][nextCity]!=0 && !vis[nextCity])
                min = Math.min(min,rec(graph,nextCity,endCity,nCities,distance+graph[startCity][nextCity],vis));
        }
        return min;
    }
    private int fastestRoute(int[][] graph,int startCity,int endCity,int nCities)
    {
        Queue<Pair> q = new LinkedList<>();
        for(int nextCity=0;nextCity<nCities;nextCity++)
        {
            q.add(new Pair(startCity,nextCity,graph[startCity][nextCity]));
        }
        int totalDistance = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int nextCity=0;nextCity<size;nextCity++)
            {

            }
        }
        return 0;
    }



    class Pair
    {
        int presentCity,nextCity,distance;
        Pair(int a,int b,int d)
        {
         this.presentCity = a;
         this.nextCity = b;
         this.distance = d;
        }
    }
}
