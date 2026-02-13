# DSA Cheatsheet for LeetCode & Coding Interviews (2026–2027 Edition)

Target: Product-based companies, startups, MAANG/FAANG-tier interviews  
Current trends (based on LeetCode frequency, company tags, recent interview reports 2025–early 2026):  
- Heavy emphasis on **Arrays + Strings + Hashing** (foundation)  
- **Sliding Window, Two Pointers, Prefix Sum** very frequent  
- **DP** (1D, 2D, subsequence) increasing sharply  
- **Graphs + BFS/DFS** remain strong (especially Google, Meta)  
- **Heaps & Greedy** important for Amazon, scheduling problems  
- **Trees** (binary tree + BST) still core  

Use `[ ]` → `[x]` to mark solved problems.  
Solve in this rough order: Arrays → Strings → Hashing → Binary Search → Linked List → Stack/Queue → Trees → Heaps → Graphs → DP → Backtracking → Others

## 1. Arrays

**Brief Intro**  
Contiguous block of same-type elements with O(1) random access.

**Why important**  
Most frequent topic. Almost every problem uses array traversal/manipulation.

**Common patterns**  
Two pointers, sliding window, prefix sum, kadane, sort + two pointers, in-place modification

### Problems
#### Easy
- [ ] 1. Two Sum  
- [ ] 26. Remove Duplicates from Sorted Array  
- [ ] 27. Remove Element  
- [ ] 88. Merge Sorted Array  
- [ ] 121. Best Time to Buy and Sell Stock  
- [ ] 136. Single Number  
- [ ] 189. Rotate Array  
- [ ] 217. Contains Duplicate  
- [ ] 283. Move Zeroes  
- [ ] 350. Intersection of Two Arrays II  

#### Medium
- [ ] 3. Longest Substring Without Repeating Characters  
- [ ] 11. Container With Most Water  
- [ ] 15. 3Sum  
- [ ] 48. Rotate Image  
- [ ] 53. Maximum Subarray  
- [ ] 56. Merge Intervals  
- [ ] 73. Set Matrix Zeroes  
- [ ] 152. Maximum Product Subarray  
- [ ] 238. Product of Array Except Self  
- [ ] 287. Find the Duplicate Number  
- [ ] 560. Subarray Sum Equals K  
- [ ] 713. Subarray Product Less Than K  
- [ ] 974. Subarray Sums Divisible by K  

#### Hard
- [ ] 4. Median of Two Sorted Arrays  
- [ ] 41. First Missing Positive  
- [ ] 42. Trapping Rain Water  
- [ ] 84. Largest Rectangle in Histogram  
- [ ] 239. Sliding Window Maximum  
- [ ] 493. Reverse Pairs  

## 2. Strings

**Brief Intro**  
Sequence of characters (often immutable in Python/Java).

**Why important**  
Very close to arrays. Many companies ask string manipulation + pattern problems.

**Common patterns**  
Two pointers, sliding window, hashing, palindrome expansion, KMP (rare)

### Problems
#### Easy
- [ ] 13. Roman to Integer  
- [ ] 14. Longest Common Prefix  
- [ ] 20. Valid Parentheses  
- [ ] 125. Valid Palindrome  
- [ ] 242. Valid Anagram  
- [ ] 344. Reverse String  
- [ ] 387. First Unique Character in a String  

#### Medium
- [ ] 3. Longest Substring Without Repeating Characters  
- [ ] 5. Longest Palindromic Substring  
- [ ] 49. Group Anagrams  
- [ ] 76. Minimum Window Substring  
- [ ] 424. Longest Repeating Character Replacement  
- [ ] 438. Find All Anagrams in a String  
- [ ] 567. Permutation in String  
- [ ] 647. Palindromic Substrings  

#### Hard
- [ ] 10. Regular Expression Matching  
- [ ] 32. Longest Valid Parentheses  
- [ ] 72. Edit Distance  
- [ ] 336. Palindrome Pairs  

## 3. Hashing (Map / Set)

**Brief Intro**  
Key-value store with average O(1) lookup/insert.

**Why important**  
Fast frequency counting, deduplication, grouping, two-sum family.

### Problems
#### Easy / Medium
- [ ] 1. Two Sum  
- [ ] 49. Group Anagrams  
- [ ] 128. Longest Consecutive Sequence  
- [ ] 136. Single Number  
- [ ] 217. Contains Duplicate  
- [ ] 242. Valid Anagram  
- [ ] 347. Top K Frequent Elements  
- [ ] 560. Subarray Sum Equals K  
- [ ] 974. Subarray Sums Divisible by K  

#### Advanced
- [ ] 380. Insert Delete GetRandom O(1)  
- [ ] 454. 4Sum II  
- [ ] 523. Continuous Subarray Sum  

## 4. Binary Search

**Brief Intro**  
Logarithmic search on sorted/monotonic data.

**Why important**  
Appears disguised in optimization problems (min/max answer).

### Problems
#### Easy
- [ ] 35. Search Insert Position  
- [ ] 69. Sqrt(x)  
- [ ] 704. Binary Search  

#### Medium
- [ ] 33. Search in Rotated Sorted Array  
- [ ] 74. Search a 2D Matrix  
- [ ] 153. Find Minimum in Rotated Sorted Array  
- [ ] 162. Find Peak Element  
- [ ] 875. Koko Eating Bananas  
- [ ] 1011. Capacity To Ship Packages Within D Days  
- [ ] 1552. Magnetic Force Between Two Balls  

#### Hard
- [ ] 4. Median of Two Sorted Arrays  
- [ ] 154. Find Minimum in Rotated Sorted Array II  

## 5. Linked List

**Brief Intro**  
Nodes with value + next pointer(s).

**Why important**  
Tests pointer manipulation, slow-fast pointers, reversal.

### Problems
#### Easy
- [ ] 21. Merge Two Sorted Lists  
- [ ] 141. Linked List Cycle  
- [ ] 206. Reverse Linked List  
- [ ] 234. Palindrome Linked List  

#### Medium
- [ ] 2. Add Two Numbers  
- [ ] 19. Remove Nth Node From End  
- [ ] 142. Linked List Cycle II  
- [ ] 143. Reorder List  
- [ ] 146. LRU Cache  
- [ ] 287. Find the Duplicate Number (cycle variant)  

#### Hard
- [ ] 23. Merge k Sorted Lists  
- [ ] 25. Reverse Nodes in k-Group  
- [ ] 138. Copy List with Random Pointer  

## 6. Stack & Queue (incl. Deque, Monotonic)

**Brief Intro**  
LIFO (stack), FIFO (queue), monotonic for next greater/smaller.

**Why important**  
Parentheses, histogram, sliding window max, next greater.

### Problems
#### Easy
- [ ] 20. Valid Parentheses  
- [ ] 155. Min Stack  

#### Medium
- [ ] 150. Evaluate Reverse Polish Notation  
- [ ] 394. Decode String  
- [ ] 739. Daily Temperatures  
- [ ] 503. Next Greater Element II  

#### Hard
- [ ] 42. Trapping Rain Water  
- [ ] 84. Largest Rectangle in Histogram  
- [ ] 239. Sliding Window Maximum  
- [ ] 895. Maximum Frequency Stack  

## 7. Binary Tree & BST

**Brief Intro**  
Hierarchical structure; BST maintains order.

**Why important**  
Traversal, path, depth, LCA, diameter very common.

### Problems
#### Easy
- [ ] 94. Binary Tree Inorder Traversal  
- [ ] 100. Same Tree  
- [ ] 101. Symmetric Tree  
- [ ] 104. Maximum Depth of Binary Tree  
- [ ] 226. Invert Binary Tree  

#### Medium
- [ ] 98. Validate Binary Search Tree  
- [ ] 102. Binary Tree Level Order Traversal  
- [ ] 105. Construct Binary Tree from Preorder and Inorder  
- [ ] 124. Binary Tree Maximum Path Sum  
- [ ] 199. Binary Tree Right Side View  
- [ ] 230. Kth Smallest Element in a BST  
- [ ] 236. Lowest Common Ancestor of a Binary Tree  
- [ ] 543. Diameter of Binary Tree  

#### Hard
- [ ] 297. Serialize and Deserialize Binary Tree  
- [ ] 124. Binary Tree Maximum Path Sum (hard variant)  

## 8. Heap / Priority Queue

**Brief Intro**  
Min/max extraction in log n.

**Why important**  
Top-k, merge k lists, median, scheduling.

### Problems
#### Medium
- [ ] 215. Kth Largest Element in an Array  
- [ ] 347. Top K Frequent Elements  
- [ ] 621. Task Scheduler  
- [ ] 973. K Closest Points to Origin  

#### Hard
- [ ] 23. Merge k Sorted Lists  
- [ ] 295. Find Median from Data Stream  
- [ ] 480. Sliding Window Median  

## 9. Graphs (BFS / DFS / Topological Sort)

**Brief Intro**  
Nodes + edges; adjacency list/matrix.

**Why important**  
Connectivity, shortest path, cycle detection.

### Problems
#### Medium
- [ ] 200. Number of Islands  
- [ ] 207. Course Schedule  
- [ ] 210. Course Schedule II  
- [ ] 417. Pacific Atlantic Water Flow  
- [ ] 994. Rotting Oranges  

#### Hard
- [ ] 743. Network Delay Time  
- [ ] 787. Cheapest Flights Within K Stops  
- [ ] 332. Reconstruct Itinerary  

## 10. Dynamic Programming

**Brief Intro**  
Memoization / tabulation of overlapping subproblems.

**Why important**  
Optimization & counting problems; rising sharply in 2026.

### Problems
#### Easy
- [ ] 70. Climbing Stairs  
- [ ] 509. Fibonacci Number  

#### Medium
- [ ] 62. Unique Paths  
- [ ] 91. Decode Ways  
- [ ] 198. House Robber  
- [ ] 213. House Robber II  
- [ ] 300. Longest Increasing Subsequence  
- [ ] 322. Coin Change  
- [ ] 416. Partition Equal Subset Sum  
- [ ] 1143. Longest Common Subsequence  

#### Hard
- [ ] 72. Edit Distance  
- [ ] 123. Best Time to Buy and Sell Stock III  
- [ ] 188. Best Time to Buy and Sell Stock IV  
- [ ] 312. Burst Balloons  

## 11. Greedy

**Brief Intro**  
Local optimal choice → global optimum.

**Why important**  
Faster than DP when it works.

### Problems
- [ ] 45. Jump Game II  
- [ ] 55. Jump Game  
- [ ] 122. Best Time to Buy and Sell Stock II  
- [ ] 435. Non-overlapping Intervals  
- [ ] 621. Task Scheduler  

## 12. Backtracking

**Brief Intro**  
Explore all possibilities + prune.

**Why important**  
Combinations, permutations, subsets.

### Problems
- [ ] 17. Letter Combinations of a Phone Number  
- [ ] 22. Generate Parentheses  
- [ ] 39. Combination Sum  
- [ ] 46. Permutations  
- [ ] 78. Subsets  
- [ ] 79. Word Search  
- [ ] 131. Palindrome Partitioning  
- [ ] 37. Sudoku Solver  
- [ ] 51. N-Queens  

## 13. Bit Manipulation

**Brief Intro**  
Operations on binary representation.

**Why important**  
XOR tricks, single number family.

### Problems
- [ ] 136. Single Number  
- [ ] 137. Single Number II  
- [ ] 191. Number of 1 Bits  
- [ ] 260. Single Number III  

## 14. Trie

**Brief Intro**  
Prefix tree for strings.

**Why important**  
Autocomplete, word search, prefix queries.

### Problems
- [ ] 208. Implement Trie (Prefix Tree)  
- [ ] 211. Add and Search Word  
- [ ] 212. Word Search II  

## 15. Union Find (Disjoint Set)

**Brief Intro**  
Efficient grouping & connectivity.

**Why important**  
Cycle detection, connected components.

### Problems
- [ ] 200. Number of Islands (variant)  
- [ ] 261. Graph Valid Tree  
- [ ] 547. Number of Provinces  
- [ ] 684. Redundant Connection  
- [ ] 721. Accounts Merge  

---

**Quick Revision Strategy (2026 style)**  
1. Finish NeetCode 150 / Blind 75 first  
2. Then Striver SDE Sheet (180–220 problems)  
3. Company tagged lists (Amazon → heaps/trees, Google → graphs, Meta → DP/strings)  
4. Weekly mock + revisit failed problems every 7–14 days  
5. Anki cards for complexities + patterns

Good luck K from Lucknow! Keep consistent — you've got this 🚀
