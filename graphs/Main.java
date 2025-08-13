package graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        visited.put(node, new Node(node.val, new ArrayList<>()));
        q.add(node);

        while (!q.isEmpty()) {
            Node t = q.remove();
            for (Node n : t.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val, new ArrayList<>()));
                    q.add(n);
                }
                visited.get(t).neighbors.add(visited.get(n));
            }
        }

        return visited.get(node);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create sample graph: 1-2, 1-4, 2-3, 3-4
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution sol = new Solution();
        Node cloned = sol.cloneGraph(node1);

        // Print cloned graph using BFS
        printGraph(cloned);
    }

    static void printGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print("Node " + curr.val + " -> ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
            System.out.println();
        }
    }
}
