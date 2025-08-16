# 📝 Java Stream API Cheat Sheet for LeetCode

## 1. **Convert Array → Stream / List**
```java
int[] arr = {1, 2, 3, 4, 5};
List<Integer> list = Arrays.stream(arr).boxed().toList(); 
// [1, 2, 3, 4, 5]
```

## 2. **Filter Elements**
```java
List<Integer> evens = list.stream()
        .filter(n -> n % 2 == 0)
        .toList(); 
// [2, 4]
```

## 3. **Map / Transform**
```java
List<Integer> squares = list.stream()
        .map(n -> n * n)
        .toList(); 
// [1, 4, 9, 16, 25]
```

## 4. **Sort**
```java
List<Integer> sorted = list.stream()
        .sorted()
        .toList(); 
// [1, 2, 3, 4, 5]

List<Integer> desc = list.stream()
        .sorted(Comparator.reverseOrder())
        .toList(); 
// [5, 4, 3, 2, 1]
```

## 5. **Distinct / Remove Duplicates**
```java
List<Integer> unique = Arrays.asList(1,2,2,3,3,4).stream()
        .distinct()
        .toList(); 
// [1, 2, 3, 4]
```

## 6. **Find Min / Max**
```java
int min = list.stream()
        .min(Integer::compare)
        .get();  // 1

int max = list.stream()
        .max(Integer::compare)
        .get();  // 5
```

## 7. **Sum / Average**
```java
int sum = list.stream()
        .mapToInt(Integer::intValue)
        .sum();  // 15

double avg = list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .getAsDouble(); // 3.0
```

## 8. **Count with Condition**
```java
long countEvens = list.stream()
        .filter(n -> n % 2 == 0)
        .count(); 
// 2
```

## 9. **AnyMatch / AllMatch / NoneMatch**
```java
boolean hasEven = list.stream().anyMatch(n -> n % 2 == 0);   // true
boolean allPositive = list.stream().allMatch(n -> n > 0);    // true
boolean noneNegative = list.stream().noneMatch(n -> n < 0);  // true
```

## 10. **First Match / Find**
```java
int firstEven = list.stream()
        .filter(n -> n % 2 == 0)
        .findFirst()
        .get(); 
// 2
```

## 11. **Reduce (Custom Aggregation)**
```java
int product = list.stream()
        .reduce(1, (a, b) -> a * b); 
// 120
```

## 12. **Collect to Map**
```java
Map<Integer, String> map = list.stream()
        .collect(Collectors.toMap(n -> n, n -> "Val:" + n));
// {1=Val:1, 2=Val:2, 3=Val:3, 4=Val:4, 5=Val:5}
```

## 13. **Group By Frequency**
```java
Map<Integer, Long> freq = Arrays.asList(1,2,2,3,3,3,4).stream()
        .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
// {1=1, 2=2, 3=3, 4=1}
```

## 14. **Find Most Frequent Element**
```java
int mostFreq = freq.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .get()
        .getKey();
// 3
```

## 15. **String Stream Tricks**
```java
String s = "leetcode";
Map<Character, Long> charFreq = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
// {l=1, e=3, t=1, c=1, o=1, d=1}
```

## 16. **Sort by Frequency**
```java
List<Integer> sortedByFreq = freq.entrySet().stream()
        .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
        .map(Map.Entry::getKey)
        .toList();
// [3, 2, 1, 4]
```

## 17. **Parallel Stream (Speed Up)**
```java
int parallelSum = list.parallelStream()
        .mapToInt(Integer::intValue)
        .sum(); 
// 15
```

## 18. **FlatMap (Nested Structures)**
```java
List<List<Integer>> nested = Arrays.asList(
    Arrays.asList(1,2),
    Arrays.asList(3,4),
    Arrays.asList(5)
);

List<Integer> flat = nested.stream()
        .flatMap(List::stream)
        .toList();
// [1, 2, 3, 4, 5]
```
