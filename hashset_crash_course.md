# Java HashSet Crash Course

## Introduction
`HashSet` in Java is a part of the `java.util` package and implements the `Set` interface.  
It stores **unique elements** and does **not maintain any order** of elements.

- **No duplicates allowed**
- **Allows null** (only one null element)
- **Backed by a HashMap**
- **Unordered** (iteration order is not guaranteed)

---

## Creating a HashSet
```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
```
You can also initialize it with values:
```java
HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3));
```

---

## Common Constructors
```java
HashSet<E> hs = new HashSet<>();                // Default capacity (16) and load factor (0.75)
HashSet<E> hs = new HashSet<>(initialCapacity); // Set initial capacity
HashSet<E> hs = new HashSet<>(initialCapacity, loadFactor); // Set capacity & load factor
HashSet<E> hs = new HashSet<>(collection);      // Create from another collection
```

---

## Important Methods

| Method | Description |
|--------|-------------|
| `add(E e)` | Adds an element to the set |
| `addAll(Collection<? extends E> c)` | Adds all elements from another collection |
| `remove(Object o)` | Removes the element if it exists |
| `removeAll(Collection<?> c)` | Removes all elements from another collection |
| `retainAll(Collection<?> c)` | Keeps only the elements present in another collection |
| `clear()` | Removes all elements |
| `contains(Object o)` | Checks if the set contains the element |
| `isEmpty()` | Checks if the set is empty |
| `size()` | Returns number of elements |
| `iterator()` | Returns an iterator to traverse the set |
| `toArray()` | Converts set to an array |
| `clone()` | Creates a shallow copy of the set |

---

## Example Usage
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple"); // Duplicate ignored

        // Checking elements
        System.out.println(fruits.contains("Apple")); // true

        // Removing element
        fruits.remove("Banana");

        // Size
        System.out.println(fruits.size()); // 2

        // Iterating
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Convert to array
        String[] fruitArray = fruits.toArray(new String[0]);

        // Clear all elements
        fruits.clear();
    }
}
```

---

## Key Points
- Best for **fast lookups** (O(1) average for add, remove, contains)
- Not thread-safe — use `Collections.synchronizedSet()` or `ConcurrentHashMap` for concurrency
- Order is not guaranteed — use `LinkedHashSet` for insertion order, `TreeSet` for sorted order

---

## Common Use Cases
1. **Removing duplicates from a list**
```java
List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4);
HashSet<Integer> unique = new HashSet<>(list);
System.out.println(unique); // [1, 2, 3, 4]
```

2. **Fast membership check**
```java
HashSet<String> allowedUsers = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie"));
if (allowedUsers.contains("Bob")) {
    System.out.println("Access granted");
}
```

3. **Set operations**
```java
HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

// Union
HashSet<Integer> union = new HashSet<>(set1);
union.addAll(set2); // [1, 2, 3, 4, 5]

// Intersection
HashSet<Integer> intersection = new HashSet<>(set1);
intersection.retainAll(set2); // [3]

// Difference
HashSet<Integer> difference = new HashSet<>(set1);
difference.removeAll(set2); // [1, 2]
```

---

## When to Use `HashSet`
- Need **unique elements**
- Fast **search, insert, delete**
- Don't care about **order**
