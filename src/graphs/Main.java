package graphs;

import java.util.*;

import static graphs.Graph.topoSortDFS;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph g1 = new Graph(5, 8);
        //g1.populate(scanner);
        //g1.getPathBfs(0, 6);
        //System.out.println(g1.isConnected());
//        g1.allConnectedComponents();

//        char[][] grid = {
//                {'1','1','0','0','0'},
//  {'1','1','0','0','0'},
//  {'0','0','1','0','0'},
//  {'0','0','0','1','1'}
//    };
//        System.out.println(g1.numIslands(grid));

        int[][] p = {
                {1,4}, {2,4}, {3,1}, {3,2}
        };
        //System.out.println(Graph.canFinishDFS(5, p));

        int V = 5;

        // Initialize the outer ArrayList with a capacity of V
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

        // Initialize each inner ArrayList
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add the paths (edges) to the graph
        graph.get(3).add(4);
        graph.get(3).add(0);
        graph.get(1).add(0);
        graph.get(2).add(0);

        System.out.println(topoSortDFS(V, graph));
    }
}
