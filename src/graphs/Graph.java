package graphs;

import java.util.*;

public class Graph {
    int n;
    int e;
    int[][] adjMatrix;
    public Graph(int n, int e) {
        this.n = n;
        this.e = e;
        this.adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            this.adjMatrix[i] = new int[n];
            for (int j = 0; j < n; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
    }
    public void populate(Scanner scanner) {
        for (int i = 0; i < e; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            this.adjMatrix[first][second] = 1;
            this.adjMatrix[second][first] = 1;
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsHelper(visited, i, n);
            }
        }
    }

    private void dfsHelper(boolean[] visited, int sv, int n) {
        System.out.print(sv + " ");
        visited[sv] = true;
        for (int i = 0; i < n; i++) {
            if (i == sv) {
                continue;
            }
            if (adjMatrix[sv][i] == 1 && !visited[i]) {
                dfsHelper(visited, i, n);
            }
        }
    }

    public void bfs() {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfsHelper(visited, i, n);
            }
        }
    }

    private void bfsHelper(boolean[] visited, int sv, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sv);
        visited[sv] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            System.out.print(currentNode + " ");
            for (int i = 0; i < n; i++) {
                if (i == currentNode) {
                    continue;
                }
                if (adjMatrix[currentNode][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void getPathDfs(int sv, int ev) {
        boolean[] visited = new boolean[n];
        getPathDfsHelper(sv, ev, visited, "");
    }

    private void getPathDfsHelper(int sv, int ev, boolean[] visited, String path) {
        if (sv == ev) {
            path = path + ev;
            StringBuilder str = new StringBuilder(path);
            System.out.println(str.reverse());
        }
        visited[sv] = true;
        for (int i = 0; i < n; i++) {
            if (sv == i) {
                continue;
            }
            if (adjMatrix[sv][i] == 1 && !visited[i]) {
                getPathDfsHelper(i, ev, visited, path + sv + " ");
            }
        }
    }

    public void getPathBfs(int sv, int ev) {
        boolean[] visited = new boolean[n];
        getPathBfsHelper(sv, ev, visited);
    }

    private void getPathBfsHelper(int sv, int ev, boolean[] visited) {
        visited[sv] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sv);
        Map<Integer, Integer> map = new HashMap<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == ev) {
                break;
            }
            for (int i = 0; i < n; i++) {
                if (curr == i) {
                    continue;
                }
                if (adjMatrix[curr][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    map.put(i, curr);
                }
            }
        }
        String path = ev + " ";
        int curr = ev;
        while (curr != sv) {
            if (map.containsKey(curr)) {
                path = path + map.get(curr) + " ";
                curr = map.get(curr);
            }
        }
        System.out.println(path);
    }

    //CODING NINJAS QUES
    public boolean isConnected() {
        boolean[] visited = new boolean[n];
        dfsHelper(visited, 0, n);

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    //CODING NINJAS QUES
    public void allConnectedComponents() {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsHelper(visited, i, n);
                System.out.println();
            }
        }
    }

    //CODING NINJAS QUES
    public int islands() {
        boolean[] visited = new boolean[n];
        int is = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsHelper(visited, i, n);
                is++;
            }
        }
        return is;
    }

    //https://leetcode.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslandsDfs(grid, visited, i, j);
                    numIslandsBfs(grid, visited, i, j);
                    num++;
                }

            }
        }
        return num;
    }

     class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void numIslandsBfs(char[][] grid, boolean[][] visited, int i, int j) {
        Pair pair = new Pair(i, j);
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(pair);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int row = curr.row;
            int col = curr.col;

            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    if (dRow == 0 || dCol == 0) {
                        int nRow = row + dRow;
                        int nCol = col + dCol;
                        if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                            queue.offer(new Pair(nRow, nCol));
                            visited[nRow][nCol] = true;
                        }
                    }
                }
            }
        }
    }

    private void numIslandsDfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        numIslandsDfs(grid, visited, i + 1, j);
        numIslandsDfs(grid, visited, i - 1, j);
        numIslandsDfs(grid, visited, i, j + 1);
        numIslandsDfs(grid, visited, i, j - 1);
    }

    //https://leetcode.com/problems/course-schedule/
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] ind = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        //Creating adjList from courses and prerequisites
        for (int[] courses : prerequisites) {
            adjList.get(courses[1]).add(courses[0]);
        }

        //populate the indegree array
        for (List<Integer> row : adjList) {
            for (int col : row) {
                ind[col]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int node : adjList.get(curr)) {
                ind[node]--;
                if (ind[node] == 0) {
                    q.offer(node);
                }
            }
        }

        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }

    //https://leetcode.com/problems/course-schedule/
    static int c = 0;
    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] item : prerequisites) {
            adjList.get(item[1]).add(item[0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(!canFinishDFSHelper(i, adjList, visited, pathVis)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canFinishDFSHelper(int sv, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVis) {
        if(visited[sv] && pathVis[sv]) {
            return false;
        }

        if(visited[sv] && !pathVis[sv]) {
            return true;
        }

        visited[sv] = true;
        pathVis[sv] = true;

        for(int i : adjList.get(sv)) {
            if(!canFinishDFSHelper(i, adjList, visited, pathVis)) {
                return false;
            }
        }

        pathVis[sv] = false;
        return true;
    }

    //https://www.geeksforgeeks.org/problems/topological-sort/1
    static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] ind = new int[V];
        for(int i=0; i<V; i++) {
            for(int j : adj.get(i)) {
                ind[j]++;
            }
        }

        Queue<Integer> q = new LinkedList();
        for(int i=0; i<V; i++){
            if(ind[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[V];
        int i = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            topo[i++] = curr;

            for(int node : adj.get(curr)) {
                ind[node]--;
                if(ind[node] == 0) {
                    q.offer(node);
                }
            }
        }
        return topo;
    }

    //https://www.geeksforgeeks.org/problems/topological-sort/1
    static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] ind = new int[V];
        for(int i=0; i<V; i++) {
            for(int j : adj.get(i)) {
                ind[j]++;
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                topoSortDFSHelper(i, adj, topo, visited, pathVis);
            }
        }

        int arr[] =  topo.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

    private static void topoSortDFSHelper(int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> topo, boolean[] vis, boolean[] pathVis) {
        vis[curr] = true;

        for(int j : adj.get(curr)) {
            if(!vis[j]) {
                topoSortDFSHelper(j, adj, topo, vis, pathVis);
            }
        }

        topo.add(0, curr);
    }

    //https://leetcode.com/problems/is-graph-bipartite/
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        String[] color = new String[V];

        for(int i=0; i<V; i++) {
            if(color[i] == null) {
                if(!isBipartiteBFSHelper(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartiteBFSHelper(int[][] graph, int start, String[] color) {
        Queue<Integer> q = new LinkedList();
        color[start] = "RED";
        q.offer(start);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int node : graph[curr]) {
                if(color[node] ==  null) {
                    if(color[curr] == "RED") {
                        color[node] = "BLUE";
                    } else {
                        color[node] = "RED";
                    }
                    q.offer(node);
                } else {
                    if(color[curr].equals(color[node])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //https://leetcode.com/problems/is-graph-bipartite/
    public boolean isBipartiteDFS(int[][] graph) {
        int V = graph.length;
        String[] color = new String[V];

        for(int i=0; i<V; i++) {
            if(color[i] == null) {
                color[i] = "RED";
                if(!isBipartiteDFSHelper(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartiteDFSHelper(int[][] graph, int curr, String[] color) {
        for(int node : graph[curr]) {
            if(color[node] != null) {
                if (color[curr].equals(color[node])) {
                    return false;
                }
            } else {
                if (color[curr].equals("BLUE")) {
                    color[node] = "RED";
                } else {
                    color[node] = "BLUE";
                }
                if(!isBipartiteDFSHelper(graph, node, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}

















