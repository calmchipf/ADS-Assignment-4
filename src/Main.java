import implementations.MyArrayList;
import implementations.MyGraph;
import implementations.MyGraphWeighted;
import searches.Dijkstra;
import sorts.QuickSort;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(12);
        myArrayList.add(15);
        System.out.println(myArrayList.toString());

        int[] arr = {1,3,4,2,3,6,7,3,8,2};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int element : arr) {
            System.out.println(element);
        }

        // Task 1 part 2:
        // For the sake of my sanity: A = 1, B = 2, C = 3, D = 4, E = 5, F = 6, G = 7.
        MyGraph myGraph = new MyGraph(7, false);

        myGraph.addEdge(1, 3);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 4);

        myGraph.addEdge(2, 1);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(2, 5);
        myGraph.addEdge(2, 7);

        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 2);
        myGraph.addEdge(3, 4);

        myGraph.addEdge(4, 3);
        myGraph.addEdge(4, 1);

        myGraph.addEdge(5, 7);
        myGraph.addEdge(5, 6);
        myGraph.addEdge(5, 2);

        myGraph.addEdge(6, 7);
        myGraph.addEdge(6, 5);

        myGraph.addEdge(7, 6);
        myGraph.addEdge(7, 2);

        myGraph.printGraph();

        myGraph.dfs();
        System.out.println();
        myGraph.bfs();
        // My implementation gives the same result

        // For the sake of my sanity:
        // Glasgow - 1, Edinburgh - 2, Stirling - 3, Perth - 4, Dundee - 5.
        MyGraphWeighted cities = new MyGraphWeighted(5, true);
        cities.addEdge(1,2,70);
        cities.addEdge(1,3,50);
        cities.addEdge(2,3,50);
        cities.addEdge(2,4,100);
        cities.addEdge(3,4,40);
        cities.addEdge(4,5,60);

        System.out.println();

        Dijkstra.dijkstra(cities, 2, 5);
        // Dijkstra's algorithm found the shortest path.

        // The examples for the third part that are not given as 'Examples' are already listed whatsoever
        // The ones that are explicitly written: RecursionExample, BigONotationExample, StackQueueExample, HashTableExample.
    }
}