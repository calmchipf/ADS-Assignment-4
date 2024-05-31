package implementations;

import java.util.LinkedList;

public class MyGraphWeighted {

    private int V, E;  // V, E - no. of vertices and edges, respectively.
    LinkedList<Edge>[] adj;

    boolean undirected = true;

    public MyGraphWeighted(int nodes, boolean undirected) {
        this.undirected = undirected;
        this.V = nodes + 1;
        this.adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, int weight)  {
        adj[u].add(new Edge(v, weight));
        E++;

        if (undirected) {
            adj[v].add(new Edge(u, weight));
        }
    }

    public void printGraph() {
        for (int v = 1; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");
            for (Edge edge : adj[v]) {
                System.out.print("(" + edge.to + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public int getV() {
        return V;
    }

    public LinkedList<Edge>[] getAdj() {
        return adj;
    }

    public static class Edge {
        public int to;
        public int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
