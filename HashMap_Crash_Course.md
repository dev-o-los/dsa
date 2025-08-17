
# Java HashMap Crash Course

## 1. Introduction
A **HashMap** in Java is part of the `java.util` package.  
It stores data in **key-value pairs**, and it uses **hashing** to make operations like insertion, search, and deletion very fast (average time complexity O(1)).  

### Key Points:
- Keys must be **unique**.
- One `null` key allowed, multiple `null` values allowed.
- Not **synchronized** (not thread-safe).
- Order of elements is **not guaranteed**.

---

## 2. Basic Syntax
```java
import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        
        // Insert values
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println(map); // {1=Apple, 2=Banana, 3=Cherry}
    }
}
```

---

## 3. Important Methods

### `put(key, value)`
Inserts a new key-value pair. If key exists, it **updates the value**.
```java
map.put(2, "Mango"); 
System.out.println(map); // {1=Apple, 2=Mango, 3=Cherry}
```

### `get(key)`
Fetches value for a given key.
```java
System.out.println(map.get(1)); // Apple
System.out.println(map.get(5)); // null (if key not found)
```

### `remove(key)`
Removes mapping for a key.
```java
map.remove(2);
System.out.println(map); // {1=Apple, 3=Cherry}
```

### `containsKey(key)` and `containsValue(value)`
Checks existence of a key or value.
```java
System.out.println(map.containsKey(1)); // true
System.out.println(map.containsValue("Banana")); // false
```

### `size()`
Returns number of key-value pairs.
```java
System.out.println(map.size()); // 2
```

### `isEmpty()`
Checks if map is empty.
```java
System.out.println(map.isEmpty()); // false
```

### `clear()`
Removes all entries.
```java
map.clear();
System.out.println(map); // {}
```

### Iterating over HashMap
```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(2, "Banana");
map.put(3, "Cherry");

// Iterate using entrySet
for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}

// Iterate using keySet
for (Integer key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}
```

---

## 4. Real-World/DSA Use Cases

### 4.1 Frequency Counter
```java
int[] nums = {1,2,2,3,1,4,2};
HashMap<Integer, Integer> freq = new HashMap<>();

for (int n : nums) {
    freq.put(n, freq.getOrDefault(n, 0) + 1);
}
System.out.println(freq); // {1=2, 2=3, 3=1, 4=1}
```

### 4.2 Two Sum (LeetCode #1)
```java
int[] nums = {2,7,11,15};
int target = 9;
HashMap<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        System.out.println("Indices: " + map.get(complement) + " and " + i);
        break;
    }
    map.put(nums[i], i);
}
// Output: Indices: 0 and 1
```

### 4.3 Group Anagrams (LeetCode #49 - simplified with HashMap)
```java
String[] words = {"eat","tea","tan","ate","nat","bat"};
HashMap<String, java.util.List<String>> map = new HashMap<>();

for (String word : words) {
    char[] arr = word.toCharArray();
    java.util.Arrays.sort(arr);
    String key = new String(arr);
    map.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(word);
}
System.out.println(map.values());
```

---

## 5. Comparison with Other Maps

- **HashMap**: Fast, allows null keys/values, unordered.
- **Hashtable**: Thread-safe but slower, does NOT allow null keys/values.
- **LinkedHashMap**: Maintains insertion order.
- **TreeMap**: Sorted order of keys (O(log n) operations).

---

## 6. Summary
- Average **O(1)** time complexity for insert/search/delete.  
- Useful in **DSA problems** (frequency maps, caching, grouping).  
- Choose **HashMap** when you need **fast lookups** without order guarantees.
