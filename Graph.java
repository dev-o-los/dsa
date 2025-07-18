import java.util.ArrayList;
import java.util.List;

/**
 * The Graph class in Java represents a graph data structure with methods to add
 * weighted edges and
 * display the adjacency matrix.
 */

public class Graph {

    int adjMat[][];
    List<List<Integer>> adjList;

    Graph(int nodes) {
        adjMat = new int[nodes][nodes];
        adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

    }

    /**
     * The function `addEdgesInMat` adds edges to an adjacency matrix based on the
     * input array of edges
     * and whether the graph is directed or undirected.
     * 
     * @param edges      The `edges` parameter is a 2D array where each row
     *                   represents an edge between two
     *                   vertices. Each row contains two elements: the source vertex
     *                   and the destination vertex of the
     *                   edge.
     * @param isDirected The `isDirected` parameter in the `addEdgesInMat` method
     *                   indicates whether the
     *                   graph is directed or undirected. If `isDirected` is `true`,
     *                   it means the graph is directed, and
     *                   edges are added only in one direction from `u` to `v`. If
     *                   `is
     */
    public void addEdgesInMat(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isDirected) {
                adjMat[u][v] = 1;
            } else {
                adjMat[u][v] = 1;
                adjMat[v][u] = 1;
            }
        }
    }

    /**
     * The function `addEdgesInList` adds edges to an adjacency list representation
     * of a graph,
     * considering whether the graph is directed or undirected.
     * 
     * @param edges      The `edges` parameter is a 2D array where each row
     *                   represents an edge between two
     *                   vertices. Each row contains two elements: the source vertex
     *                   and the destination vertex of the
     *                   edge.
     * @param isDirected The `isDirected` parameter is a boolean value that
     *                   indicates whether the graph
     *                   is directed or undirected. If `isDirected` is true, it
     *                   means the graph is directed, and if it is
     *                   false, it means the graph is undirected.
     */
    public void addEdgesInList(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isDirected) {
                adjList.get(u).add(v);
            } else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    /**
     * The function `addWeightedGraph` adds weighted edges to an adjacency matrix
     * based on the input
     * edges array and whether the graph is directed or undirected.
     * 
     * @param edges      The `edges` parameter is a 2D array where each row
     *                   represents an edge in the graph.
     *                   Each row contains three elements: the starting vertex `u`,
     *                   the ending vertex `v`, and the weight
     *                   `w` of the edge between `u` and `v`.
     * @param isDirected The `isDirected` parameter in the `addWeightedGraph` method
     *                   indicates whether
     *                   the graph is directed or undirected. If `isDirected` is
     *                   `true`, it means the graph is directed,
     *                   and the edges have a specific direction from one vertex to
     *                   another. If `isDirected` is
     */
    public void addWieghtedGraph(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected) {
                adjMat[u][v] = w;
            } else {
                adjMat[u][v] = w;
                adjMat[v][u] = w;
            }
        }
    }

    public void display() {
        for (int i = 0; i < adjMat.length; i++) {
            System.err.print("row " + i + "-> ");
            for (int j = 0; j < adjMat[0].length; j++) {
                System.out.print(adjMat[i][j] + ",");
            }
            System.out.println();
        }
    }

    public void displayList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + "-> ");
            System.out.print(adjList.get(i));

        }
    }

    public void findDegreeInUnDirectedGraph(int edges[][], int nodes) {
        int degree[] = new int[nodes];
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }

        for (int i = 0; i < nodes; i++) {
            System.out.println("node => " + i + " degree => " + degree[i]);
        }
    }

    public void findDegreeOutUnDirectedGraph(int edges[][], int nodes) {
        int indegree[] = new int[nodes];
        int outdegree[] = new int[nodes];
        for (int edge[] : edges) {
            int from = edge[0];
            int to = edge[1];

            indegree[to]++;
            outdegree[from]++;
        }

        for (int i = 0; i < nodes; i++) {
            System.out.print("node => " + i + " in-degree => " + indegree[i]);
            System.out.println("node => " + i + " out-degree => " + outdegree[i]);
        }
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 2 }, { 0, 1 }, { 1, 3 } };
        int nodes = 4;
        Graph graph = new Graph(nodes);
        graph.findDegreeInUnDirectedGraph(edges, nodes);
        graph.findDegreeOutUnDirectedGraph(edges, nodes);

        // graph.addEdgesInMat(edges, true);
        // graph.display();

        // graph.addWieghtedGraph(edges, true);
        // graph.display();

        // graph.addEdgesInList(edges, false);

    }
}