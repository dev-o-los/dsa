# Java List Crash Course

A **List** in Java is an ordered collection (also called a sequence). It allows **duplicate elements** and maintains the **insertion order**.

Common Implementations:
- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack` (extends Vector)

---

## 1. List Interface

```java
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println(list); // [Apple, Banana, Mango]
    }
}
```

### Key Methods
- `add(E e)` → Add element
- `add(int index, E e)` → Add element at index
- `get(int index)` → Get element at index
- `set(int index, E e)` → Replace element at index
- `remove(int index)` → Remove by index
- `remove(Object o)` → Remove by value
- `contains(Object o)` → Check existence
- `isEmpty()` → Check if list is empty
- `size()` → Returns size
- `indexOf(Object o)` → First occurrence index
- `lastIndexOf(Object o)` → Last occurrence index
- `clear()` → Removes all elements
- `subList(int from, int to)` → Returns portion of list

---

## 2. ArrayList
- Backed by a **dynamic array**.
- Fast random access (`get`, `set` are O(1)).
- Insertion/deletion in middle is slow (O(n)).

```java
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);

        System.out.println(arr); // [10, 20, 30]

        arr.set(1, 99);
        System.out.println(arr); // [10, 99, 30]

        arr.remove(0);
        System.out.println(arr); // [99, 30]
    }
}
```

---

## 3. LinkedList
- Implemented as a **doubly-linked list**.
- Insertion and deletion are fast (O(1)) if node reference is known.
- Random access is slower (O(n)).

```java
import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("A");
        ll.add("B");
        ll.add("C");

        System.out.println(ll); // [A, B, C]

        ll.addFirst("Start");
        ll.addLast("End");
        System.out.println(ll); // [Start, A, B, C, End]

        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll); // [A, B, C]
    }
}
```

---

## 4. Vector
- **Synchronized** (thread-safe).
- Slower than `ArrayList` for single-threaded programs.
- Rarely used in modern code.

```java
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();

        vec.add(1);
        vec.add(2);
        vec.add(3);

        System.out.println(vec); // [1, 2, 3]

        vec.remove(1);
        System.out.println(vec); // [1, 3]
    }
}
```

---

## 5. Stack (extends Vector)
- LIFO (Last In First Out).
- Provides `push`, `pop`, and `peek`.

```java
import java.util.*;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack); // [10, 20, 30]

        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop());  // 30
        System.out.println(stack);        // [10, 20]
    }
}
```

---

## 6. Differences

| Feature          | ArrayList         | LinkedList       | Vector           | Stack         |
|------------------|------------------|-----------------|-----------------|--------------|
| Backed By        | Dynamic Array    | Doubly Linked   | Dynamic Array   | Vector (LIFO)|
| Access Time      | O(1)             | O(n)            | O(1)            | O(1)         |
| Insertion/Deletion | O(n)           | O(1)            | O(n)            | O(1) (top)   |
| Thread-Safe      | No               | No              | Yes             | Yes          |

---

## 7. When to Use?
- `ArrayList` → When fast access is required.
- `LinkedList` → When frequent insertions/deletions are required.
- `Vector` → When thread safety is required (legacy).
- `Stack` → When LIFO behavior is needed.

---
