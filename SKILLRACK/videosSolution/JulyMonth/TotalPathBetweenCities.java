package SKILLRACK.videosSolution.JulyMonth;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TotalPathBetweenCities {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        adjMatrix.add(new ArrayList<>(Arrays.asList(1,2)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(1,3)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(3,4)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(4,1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(3,2)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(5,6)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(6,4)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(5,7)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(6,7)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(7,8)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(3,7)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(1,7 )));
        adjMatrix.add(new ArrayList<>(Arrays.asList(2,5)));

        int source = 1;
        int destination = 8;
        boolean[] vis = new boolean[9];
        //System.out.println(possiblePaths(adjMatrix,source,destination,vis));
        returnPossiblePath(adjMatrix,source,destination,vis);
    }
    private static void returnPossiblePath(ArrayList<ArrayList<Integer>> adjMatrix, int source ,int destination,boolean[] visited)
    {
        ArrayList<Integer> paths = new ArrayList<>();
        paths.add(0,source);
        pathFinder(adjMatrix,source,destination,visited,paths);
    }
    private static void pathFinder(ArrayList<ArrayList<Integer>> adjMatrix, int source ,int destination,boolean[] visited
            ,ArrayList<Integer> paths)
    {
        if(source==destination)
        {
            System.out.println(paths);
            return ;
        }
        if(visited[source]) return ;
        visited[source] = true;
        for(ArrayList<Integer> temp : adjMatrix)
        {
            if(temp.get(0)==source)
            {
                paths.add(temp.get(1));
                pathFinder(adjMatrix, temp.get(1),destination,visited,paths);
                paths.remove(paths.size()-1);
            }
        }
        visited[source]  = false;
    }

    private static int possiblePaths(ArrayList<ArrayList<Integer>> adjMatrix, int source ,int destination,boolean[] visited)
    {
        if(source==destination) return 1;

        if(visited[source]) return 0;
        visited[source]=true;
        int pathCount=0;
        for(ArrayList<Integer> temp : adjMatrix)
        {
            if(temp.get(0)==source)
            {
                pathCount+= possiblePaths(adjMatrix, temp.get(1),destination,visited);
            }
        }
        visited[source]= false;
        return pathCount;
    }
}

