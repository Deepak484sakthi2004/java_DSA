package SKILLRACK.videosSolution.JulyMonth;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

// given the the adjacency matrix of a unweigh direct graph, find if there a path btwn, the source and destination!!

public class PathBetweenSourceAndDestination {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();

        adjMatrix.add(new ArrayList<>(Arrays.asList(1,2)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(2,3)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(3,6)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(2,4)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(4,1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(5,1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(6,7)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(7,8)));

        int source = 1;
        int destination = 8;
        returnPath(adjMatrix, source, destination, new HashSet<Integer>());
        System.out.println();
    }
    private static void returnPath(ArrayList<ArrayList<Integer>> adjMatrix, int source, int destination, HashSet<Integer> visited)
    {
        List<Integer> path = new ArrayList<>();
        if (pathFinder(adjMatrix,source,destination,visited,path))
            System.out.println(path);
        else
            System.out.println("No path found!");

    }
    private static boolean pathFinder(ArrayList<ArrayList<Integer>> adjMatrix, int source, int destination, HashSet<Integer> visited,List<Integer> path)
    {
        if(source == destination) return true;

        if(visited.contains(source)) return false;
        visited.add(source);
        for(ArrayList<Integer> temp : adjMatrix)
        {
            if(temp.get(0)==source)
            {
                path.add(temp.get(1));
                if(pathFinder(adjMatrix,temp.get(1),destination,visited,path))
                {
                    return true;
                }
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private static boolean hasPath(ArrayList<ArrayList<Integer>> adjMatrix, int source, int destination, HashSet<Integer> visited) {
        if (source == destination) return true;

        if (visited.contains(source)) return false;
        visited.add(source);

        for (ArrayList<Integer> edge : adjMatrix) {
            if (edge.get(0) == source) {
                if (hasPath(adjMatrix, edge.get(1), destination, visited)) return true;
            }
        }
        return false;
    }
}