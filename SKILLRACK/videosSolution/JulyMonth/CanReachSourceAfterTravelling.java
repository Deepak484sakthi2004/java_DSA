package SKILLRACK.videosSolution.JulyMonth;

// is it possible to reach the source node after travelling minimum of X nodes!!
public class CanReachSourceAfterTravelling {
    public static void main(String[] args) {
        int[][] graph =
                {
                        {0, 10, 0, 0, 27},
                        {0, 0, 0, 12, 0},
                        {0, 2, 0, 1, 1},
                        {0, 0, 4, 5, 1},
                        {0,1,1,1,0}
                };
        int nVertices = graph.length;
        int source = 0;
        int X = 1;
        boolean[] vis = new boolean[nVertices];
        boolean out = canReach(graph, source, source, X, 0, vis);
        System.out.println(out);
    }

    private static boolean canReach(int[][] graph, int source, int destination, int minCity, int curCount, boolean[] vis) {
        if (curCount >= minCity && source == destination)
            return true;
        if (vis[source] && curCount >= minCity)
            return true;
        vis[source] = true;
        for (int nextCity = 0; nextCity < graph[0].length; nextCity++) {
            if (graph[source][nextCity] > 0) {
                if (canReach(graph, nextCity, destination, minCity, curCount + 1, vis))
                    return true;
            }
        }
        vis[source] = false;
        return false;
    }
}