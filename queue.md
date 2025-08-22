## Introduction to Queues in Java

A **Queue** is a data structure that follows the **First-In, First-Out (FIFO)** principle. Think of it like a line at a ticket counter: the first person to get in line is the first person to be served.

In a queue, elements are added to the "back" (also called the **tail** or **rear**) and are removed from the "front" (also called the **head**). This behavior makes queues perfect for managing tasks, handling requests in web servers, implementing breadth-first search in graphs, and managing print jobs.

## The `Queue` Interface

In Java, `Queue` is an interface found in the `java.util` package. You don't create an instance of `Queue` directly; instead, you use a class that _implements_ this interface.

The interface provides a standard set of methods for all queue implementations. These methods come in two flavors: one that throws an exception if the operation fails, and another that returns a special value (like `null` or `false`).

| Operation           | Throws Exception | Returns Special Value | Description                                                                                                                                                              |
| :------------------ | :--------------- | :-------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add Element**     | `add(e)`         | `offer(e)`            | Inserts an element at the tail of the queue. `offer()` is generally preferred as it doesn't crash your program if the queue is full (in cases of fixed-capacity queues). |
| **Remove Element**  | `remove()`       | `poll()`              | Removes and returns the element at the head of the queue. `poll()` is preferred because it returns `null` if the queue is empty, avoiding an exception.                  |
| **Examine Element** | `element()`      | `peek()`              | Returns the element at the head of the queue _without_ removing it. `peek()` is preferred as it returns `null` for an empty queue.                                       |

**Best Practice:** In most applications, it's safer and cleaner to use the methods that return a special value (`offer()`, `poll()`, and `peek()`) to avoid having to handle exceptions for common conditions like an empty queue.

## Common `Queue` Implementations

You choose the implementation based on your specific needs for ordering and performance.

### 1. `LinkedList`

This is the most common, all-purpose implementation of the `Queue` interface. It uses a doubly-linked list to store elements.

- **Behavior:** Strict FIFO ordering.
- **Performance:** Excellent. Adding (`offer`) and removing (`poll`) elements are **O(1)** operations, meaning they take constant time regardless of the queue's size.
- **Use Case:** Your go-to choice for a standard, reliable FIFO queue.

**Example:**

```java
// LinkedList is a class that implements the Queue interface
Queue<String> customerLine = new LinkedList<>();

customerLine.offer("Alice");
customerLine.offer("Bob");
customerLine.offer("Charlie");

System.out.println("Next to be served: " + customerLine.peek()); // Outputs: Alice
System.out.println("Serving: " + customerLine.poll());       // Outputs: Alice
System.out.println("Next in line: " + customerLine.peek());  // Outputs: Bob
```
