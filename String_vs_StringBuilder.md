# 📘 Java Crash Course: String vs StringBuilder

Strings are one of the most used concepts in Java and a must-know for **LeetCode** and coding interviews. This guide will give you a beginner-to-advanced understanding of `String` and `StringBuilder` with practical examples.

---

## 🔹 1. String (Immutable)
- A `String` in Java is **immutable**, meaning once created, it cannot be changed.
- Every modification creates a **new object** in memory.

```java
String s = "Hello";
s = s + " World"; // Creates a new String object
System.out.println(s); // Hello World
```

### ✅ Common String Methods

#### 1. `length()`
Returns the number of characters in the string.
```java
String s = "Java";
System.out.println(s.length()); // 4
```

#### 2. `charAt(int index)`
Returns the character at the given index.
```java
String s = "Hello";
System.out.println(s.charAt(1)); // 'e'
```

#### 3. `substring(int begin, int end)`
Extracts a substring.
```java
String s = "LeetCode";
System.out.println(s.substring(0, 4)); // Leet
```

#### 4. `indexOf()` & `lastIndexOf()`
Finds the first/last occurrence of a character or substring.
```java
String s = "banana";
System.out.println(s.indexOf("a")); // 1
System.out.println(s.lastIndexOf("a")); // 5
```

#### 5. `equals()` vs `==`
- `equals()` checks **content**.
- `==` checks **memory reference**.
```java
String a = new String("hello");
String b = new String("hello");
System.out.println(a.equals(b)); // true
System.out.println(a == b); // false
```

#### 6. `equalsIgnoreCase()`
Ignores case sensitivity.
```java
System.out.println("Java".equalsIgnoreCase("java")); // true
```

#### 7. `contains()`
Checks if substring exists.
```java
System.out.println("Hello World".contains("World")); // true
```

#### 8. `startsWith()` & `endsWith()`
```java
String s = "HelloWorld";
System.out.println(s.startsWith("Hello")); // true
System.out.println(s.endsWith("World")); // true
```

#### 9. `toUpperCase()` & `toLowerCase()`
```java
System.out.println("java".toUpperCase()); // JAVA
System.out.println("JAVA".toLowerCase()); // java
```

#### 10. `trim()`
Removes leading and trailing spaces.
```java
String s = "   hello   ";
System.out.println(s.trim()); // "hello"
```

#### 11. `replace()` & `replaceAll()`
```java
System.out.println("abcabc".replace("a", "x")); // xbcxbc
System.out.println("123-456".replaceAll("-", "")); // 123456
```

#### 12. `split()`
Splits into an array.
```java
String s = "a,b,c";
String[] arr = s.split(",");
System.out.println(Arrays.toString(arr)); // [a, b, c]
```

#### 13. `isEmpty()` & `isBlank()` (Java 11+)
```java
System.out.println("".isEmpty()); // true
System.out.println("   ".isBlank()); // true
```

#### 14. `valueOf()`
Converts other types to string.
```java
int n = 100;
String s = String.valueOf(n);
System.out.println(s + 1); // "1001"
```

#### 15. `compareTo()` & `compareToIgnoreCase()`
Lexicographical comparison.
```java
System.out.println("apple".compareTo("banana")); // negative
System.out.println("apple".compareToIgnoreCase("APPLE")); // 0
```

---

## 🔹 2. StringBuilder (Mutable)
- A `StringBuilder` is **mutable**, meaning modifications happen in the same object.
- Useful for problems with **lots of string modifications** (like LeetCode problems).

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb); // Hello World
```

### ✅ Common StringBuilder Methods

#### 1. `append()`
Adds text at the end.
```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" Rocks");
System.out.println(sb); // Java Rocks
```

#### 2. `insert(int offset, String str)`
```java
StringBuilder sb = new StringBuilder("HelloWorld");
sb.insert(5, " ");
System.out.println(sb); // Hello World
```

#### 3. `delete(int start, int end)`
```java
StringBuilder sb = new StringBuilder("abcdef");
sb.delete(2, 4);
System.out.println(sb); // abef
```

#### 4. `deleteCharAt(int index)`
```java
StringBuilder sb = new StringBuilder("hello");
sb.deleteCharAt(1);
System.out.println(sb); // hllo
```

#### 5. `replace(int start, int end, String str)`
```java
StringBuilder sb = new StringBuilder("hello");
sb.replace(0, 2, "yo");
System.out.println(sb); // yollo
```

#### 6. `reverse()`
```java
StringBuilder sb = new StringBuilder("abcd");
sb.reverse();
System.out.println(sb); // dcba
```

#### 7. `capacity()` & `ensureCapacity()`
```java
StringBuilder sb = new StringBuilder();
System.out.println(sb.capacity()); // default 16
sb.ensureCapacity(50);
System.out.println(sb.capacity()); // >=50
```

#### 8. `length()` & `setLength()`
```java
StringBuilder sb = new StringBuilder("hello");
System.out.println(sb.length()); // 5
sb.setLength(2);
System.out.println(sb); // he
```

#### 9. `charAt(int index)` & `setCharAt(int index, char ch)`
```java
StringBuilder sb = new StringBuilder("test");
System.out.println(sb.charAt(1)); // e
sb.setCharAt(1, 'a');
System.out.println(sb); // tast
```

#### 10. `substring(int start, int end)`
Same as in String but returns a **String**.
```java
StringBuilder sb = new StringBuilder("hello");
System.out.println(sb.substring(1, 4)); // ell
```

---

## 🔹 3. String vs StringBuilder

| Feature | String | StringBuilder |
|---------|--------|----------------|
| Mutability | Immutable | Mutable |
| Performance | Slower (creates new objects) | Faster (modifies in place) |
| Thread-Safe? | Yes | No |
| Use Case | When string rarely changes | When frequent modifications are needed |

---

## 🔹 4. LeetCode Use-Cases

### ✅ Reverse a String
```java
String s = "hello";
StringBuilder sb = new StringBuilder(s);
System.out.println(sb.reverse().toString()); // olleh
```

### ✅ Check Palindrome
```java
String s = "madam";
StringBuilder sb = new StringBuilder(s);
System.out.println(s.equals(sb.reverse().toString())); // true
```

### ✅ Efficient Concatenation
```java
StringBuilder sb = new StringBuilder();
for(int i=0; i<5; i++){
    sb.append(i).append(", ");
}
System.out.println(sb); // 0, 1, 2, 3, 4, 
```

### ✅ Remove Characters
```java
StringBuilder sb = new StringBuilder("leetcode");
sb.deleteCharAt(2);
System.out.println(sb); // letcode
```

---

## 🎯 Key Takeaways
- Use **String** when content is constant.
- Use **StringBuilder** for heavy modifications.
- Always consider **time complexity** in coding interviews.

---

🔥 With this crash course, you now know **all important String and StringBuilder methods** for interviews and LeetCode!
