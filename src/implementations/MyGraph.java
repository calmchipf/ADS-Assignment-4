package implementations;

import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {

    private int V, E;  // V, E - no. of vertexes and edges, respectively.
    LinkedList<Integer>[] adj;

    boolean undirected = true;

    public MyGraph(int nodes, boolean undirected) {
        this.undirected = undirected;
        this.V = nodes + 1;
        this.adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v)  {
        adj[u].add(v);
        E++;

        if (undirected){
            adj[v].add(u);
        }
    }

    public void printGraph() {

        for (int v = 1; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");
            for (int w = 0; w < adj[v].size(); w++) {
                System.out.print(adj[v].get(w) + " ");
            }
            System.out.println();
        }
    }
    public void dfs() {
        boolean visited[] = new boolean[V];

        for (int v = 1; v < V; v++) {
            if (!visited[v]) {
                visitNode(v, visited);
            }
        }
    }

    public void visitNode(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int w = 0; w < adj[v].size(); w++) {
            if (!visited[adj[v].get(w)]) {
                visitNode(adj[v].get(w), visited);
            }
        }
    }

    public void bfs() {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        for (int v = 1; v < V; v++) {
            if (!visited[v]) {
                visited[v] = true;
                queue.add(v);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");

                    for (int w = 0; w < adj[node].size(); w++) {
                        int nextNode = adj[node].get(w);
                        if (!visited[nextNode]) {
                            visited[nextNode] = true;
                            queue.add(nextNode);
                        }
                    }
                }
            }
        }
    }

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

}
