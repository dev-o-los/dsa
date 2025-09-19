/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Idea
// Step 1: Traverse the original list and create a copy of every node (but ignore random pointers for now). Store a mapping from original nodes → new nodes in a HashMap.
// Step 2: Traverse again, this time fix the next and random pointers using the map.
// This ensures every node gets copied, but it requires extra space (HashMap).

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

/*
 * // Definition for a Node.
 * class Node {
 * int val;
 * Node next;
 * Node random;
 * 
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 */

// Idea
// We want to remove the need for HashMap. Trick:
// Step 1 (Weave): For each node, create its copy right next to it in the list.
// Example: Original A → B → C becomes: A → A’ → B → B’ → C → C’.
// Step 2 (Assign randoms): Since A'.random = A.random.next, we can set random
// pointers without using extra space.
// Step 3 (Unweave): Separate the original and copied lists.

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;

            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;

    }
}