/**
 * The Graph class in Java represents a graph data structure with methods to add
 * weighted edges and
 * display the adjacency matrix.
 */

public class Graph {

    int adjMat[][];

    Graph(int nodes) {
        adjMat = new int[nodes][nodes];
    }

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

    public static void main(String[] args) {
        int edges[][] = { { 0, 2, 10 }, { 0, 1, 20 }, { 1, 3, 30 } };
        int nodes = 4;
        Graph graph = new Graph(nodes);
        // graph.addEdgesInMat(edges, true);
        // graph.display();

        graph.addWieghtedGraph(edges, true);
        graph.display();

    }
}