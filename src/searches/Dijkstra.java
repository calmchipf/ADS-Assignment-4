package searches;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.LinkedList;
import implementations.MyGraph;
import implementations.MyGraphWeighted;

public class Dijkstra {

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(MyGraph graph, int start, int finish) {
        int V = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();
        int[] distances = new int[V];
        int[] previous = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (int v : adj[u]) {
                int weight = 1; // Assuming the weight of each edge is 1

                if (!visited[v] && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        printPath(previous, start, finish);
    }

    public static void dijkstra(MyGraphWeighted graph, int start, int finish) {
        int V = graph.getV();
        LinkedList<MyGraphWeighted.Edge>[] adj = graph.getAdj();
        int[] distances = new int[V];
        int[] previous = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (MyGraphWeighted.Edge edge : adj[u]) {
                int v = edge.to;
                int weight = edge.weight;

                if (!visited[v] && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        printPath(previous, start, finish);
    }

    private static void printPath(int[] previous, int start, int finish) {
        LinkedList<Integer> path = new LinkedList<>();
        for (int at = finish; at != -1; at = previous[at]) {
            path.addFirst(at);
        }

        if (path.getFirst() == start) {
            System.out.println("Shortest path from " + start + " to " + finish + ": " + path);
        } else {
            System.out.println("No path from " + start + " to " + finish);
        }
    }
}
