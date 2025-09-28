
# Queue in Java – Complete Guide for LeetCode

A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.  
Think of it like a line at a ticket counter — the person who comes first is served first.

---

## 1. Queue Interface in Java
In Java, `Queue` is an **interface** in `java.util` package. Common implementations are:
- `LinkedList`
- `PriorityQueue`
- `ArrayDeque`

```java
Queue<Integer> queue = new LinkedList<>();
```

---

## 2. Common Queue Functions

### Adding Elements
- **`add(E e)`** → Inserts element, throws exception if capacity is full.
- **`offer(E e)`** → Inserts element, returns `true` if successful, `false` otherwise.

```java
queue.add(10);
queue.offer(20);
```

### Removing Elements
- **`remove()`** → Removes head, throws exception if empty.
- **`poll()`** → Removes head, returns `null` if empty.

```java
queue.remove(); // removes 10
queue.poll();   // removes 20
```

### Accessing Head
- **`element()`** → Retrieves head, throws exception if empty.
- **`peek()`** → Retrieves head, returns `null` if empty.

```java
queue.add(30);
System.out.println(queue.peek());    // 30
System.out.println(queue.element()); // 30
```

---

## 3. When to Use Queue in LeetCode

Queues are extremely useful in problems involving **level-order processing** or **sequential traversal**.  
Some common patterns:

1. **Breadth-First Search (BFS)**  
   - Used in trees, graphs, shortest path problems.
   - Queue ensures we process nodes level by level.

2. **Sliding Window Problems**  
   - Double-ended queue (`Deque`) helps maintain max/min in a window.

3. **Producer–Consumer Simulation**  
   - Queue models scheduling, job processing.

4. **Topological Sorting (Kahn’s Algorithm)**  
   - Queue stores nodes with no incoming edges.

---

## 4. Example Problems

### Example 1: BFS in Binary Tree (Level Order Traversal)

```java
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }
}
```

👉 Queue ensures nodes are processed **level by level**.

---

### Example 2: Sliding Window Maximum (Using Deque)

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1)
                result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }
}
```

👉 Deque maintains **indexes of candidates for max** in each window.

---

### Example 3: Graph BFS

```java
import java.util.*;

class Solution {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
}
```

👉 Standard BFS template for graphs.

---

### Example 4: Topological Sort (Kahn’s Algorithm)

```java
import java.util.*;

class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] result = new int[V];
        int idx = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[idx++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return result;
    }
}
```

👉 Queue holds nodes with indegree 0, ensuring valid ordering.

---

## 5. Smart Moves / Short Tricks

1. **For BFS** → Always use `queue.offer()` and `queue.poll()` inside while loop.

2. **Sliding Window Problems** → Use `Deque` for efficient max/min retrieval.

3. **When to choose LinkedList vs ArrayDeque**
   - `LinkedList` → more flexible, but slightly slower.
   - `ArrayDeque` → faster, no capacity restrictions (recommended in most LeetCode problems).

4. **Topological Sort Trick** → Push all indegree-0 nodes into queue at the start.

5. **Queue Size as Level Indicator** → Store `size = queue.size()` before loop for level traversal.

---

## 6. Quick Reference Table

| Operation         | Method         | Returns         | Throws Exception? |
|-------------------|----------------|-----------------|-------------------|
| Insert            | add(e)         | true            | Yes               |
| Insert            | offer(e)       | true/false      | No                |
| Remove head       | remove()       | element         | Yes               |
| Remove head       | poll()         | element/null    | No                |
| Peek head         | element()      | element         | Yes               |
| Peek head         | peek()         | element/null    | No                |

---

## 7. Key Takeaways
- Use **Queue** when order matters (BFS, scheduling).
- Use **Deque** for sliding window & monotonic operations.
- Always remember:
  - `offer` + `poll` = safe
  - `add` + `remove` = may throw exceptions
- For LeetCode, prefer **`ArrayDeque`** over `LinkedList`.
