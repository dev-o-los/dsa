# High-Frequency Arrays & Strings DSA Sheet (2025–2026 Interviews)
Focus: Freshers, Interns, SDE-1 roles at FAANG / top tech (Google, Amazon, Meta, Microsoft, etc.)

**Selection basis**: Problems frequently appearing in  
- LeetCode Top Interview 150  
- Blind 75 (still relevant in 2025–2026)  
- Company-wise recent frequency lists (2024–2025 data from LeetCode discuss, Reddit, Blind)  
- Patterns: Two Pointers, Sliding Window, Hashing, Prefix Sum, Greedy, Sorting

**Practice strategy**:
- Solve → Optimize (aim O(n) time / O(1) extra space when possible)
- Do 3–5 times per problem (brute → optimal → variations)
- Track time taken & edge cases
- Prioritize **Very High** → **High** frequency first

**Legend**  
- [ ] = Not done / Retry needed  
- [x] = Solved (can mark as you go)  
- Freq: Very High (>10–15% interviews), High, Medium (based on 2024–2025 reports)

## Arrays – Easy

- [ ] **Two Sum**  
  Link: https://leetcode.com/problems/two-sum/  
  Pattern: Hashing  
  Freq: **Very High** (almost every company)  
  Key: One-pass hashmap

- [ ] **Contains Duplicate**  
  Link: https://leetcode.com/problems/contains-duplicate/  
  Pattern: Hash Set  
  Freq: **High**

- [ ] **Best Time to Buy and Sell Stock**  
  Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/  
  Pattern: Greedy / One pass  
  Freq: **High**

- [ ] **Merge Sorted Array**  
  Link: https://leetcode.com/problems/merge-sorted-array/  
  Pattern: Two Pointers (backward)  
  Freq: **High**

- [ ] **Remove Duplicates from Sorted Array**  
  Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/  
  Pattern: Two Pointers  
  Freq: **High**

- [ ] **Remove Element**  
  Link: https://leetcode.com/problems/remove-element/  
  Pattern: Two Pointers  
  Freq: **Medium–High**

- [ ] **Majority Element**  
  Link: https://leetcode.com/problems/majority-element/  
  Pattern: Boyer-Moore Voting  
  Freq: **High**

## Arrays – Medium

- [ ] **Rotate Array**  
  Link: https://leetcode.com/problems/rotate-array/  
  Pattern: Reversal / Math  
  Freq: **High**

- [ ] **Product of Array Except Self**  
  Link: https://leetcode.com/problems/product-of-array-except-self/  
  Pattern: Prefix + Suffix (O(1) space)  
  Freq: **Very High**

- [ ] **Maximum Subarray** (Kadane’s)  
  Link: https://leetcode.com/problems/maximum-subarray/  
  Pattern: DP / Greedy  
  Freq: **High**

- [ ] **Container With Most Water**  
  Link: https://leetcode.com/problems/container-with-most-water/  
  Pattern: Two Pointers  
  Freq: **Very High** (Google ~12%)

- [ ] **3Sum**  
  Link: https://leetcode.com/problems/3sum/  
  Pattern: Two Pointers + Sorting  
  Freq: **Very High**

- [ ] **Longest Consecutive Sequence**  
  Link: https://leetcode.com/problems/longest-consecutive-sequence/  
  Pattern: Hash Set  
  Freq: **High**

- [ ] **Top K Frequent Elements**  
  Link: https://leetcode.com/problems/top-k-frequent-elements/  
  Pattern: Heap / Bucket Sort  
  Freq: **High**

## Arrays – Hard / Advanced Medium

- [ ] **Trapping Rain Water**  
  Link: https://leetcode.com/problems/trapping-rain-water/  
  Pattern: Two Pointers / Prefix Max  
  Freq: **High** (Google ~11%)

- [ ] **Sliding Window Maximum**  
  Link: https://leetcode.com/problems/sliding-window-maximum/  
  Pattern: Deque  
  Freq: **Medium–High**

## Strings – Easy

- [ ] **Valid Anagram**  
  Link: https://leetcode.com/problems/valid-anagram/  
  Pattern: Hashing / Counting  
  Freq: **High**

- [ ] **Reverse String**  
  Link: https://leetcode.com/problems/reverse-string/  
  Pattern: Two Pointers  
  Freq: **Medium–High**

- [ ] **Longest Common Prefix**  
  Link: https://leetcode.com/problems/longest-common-prefix/  
  Pattern: Horizontal scan / Trie  
  Freq: **Medium**

## Strings – Medium

- [ ] **Longest Substring Without Repeating Characters**  
  Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/  
  Pattern: **Sliding Window**  
  Freq: **Very High** (Google ~15%)

- [ ] **Group Anagrams**  
  Link: https://leetcode.com/problems/group-anagrams/  
  Pattern: Hashing (sorted key / count tuple)  
  Freq: **Very High**

- [ ] **String to Integer (atoi)**  
  Link: https://leetcode.com/problems/string-to-integer-atoi/  
  Pattern: Careful parsing  
  Freq: **Medium**

- [ ] **Find the Index of the First Occurrence in a String** (KMP / built-in)  
  Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/  
  Pattern: String matching  
  Freq: **Medium**

- [ ] **Permutation in String**  
  Link: https://leetcode.com/problems/permutation-in-string/  
  Pattern: Sliding Window + Count  
  Freq: **High**

- [ ] **Longest Repeating Character Replacement**  
  Link: https://leetcode.com/problems/longest-repeating-character-replacement/  
  Pattern: Sliding Window  
  Freq: **High**

## Strings – Hard / Advanced Medium

- [ ] **Minimum Window Substring**  
  Link: https://leetcode.com/problems/minimum-window-substring/  
  Pattern: Sliding Window + Two pointers + Counter  
  Freq: **High** (Amazon frequent)

- [ ] **Valid Palindrome II** (can delete at most one char)  
  Link: https://leetcode.com/problems/valid-palindrome-ii/  
  Pattern: Two Pointers  
  Freq: **Medium–High**

- [ ] **Encode and Decode Strings** (design)  
  Link: https://leetcode.com/problems/encode-and-decode-strings/  
  Pattern: Design / Delimiter  
  Freq: **Medium** (system-like question)

## Quick Revision Must-Dos (Top 12–15 – solve these 10+ times)

1. Two Sum  
2. Longest Substring Without Repeating Characters  
3. 3Sum  
4. Container With Most Water  
5. Product of Array Except Self  
6. Group Anagrams  
7. Longest Consecutive Sequence  
8. Trapping Rain Water  
9. Minimum Window Substring  
10. Best Time to Buy and Sell Stock  
11. Valid Anagram  
12. Merge Sorted Array  
13. Remove Duplicates from Sorted Array  
14. Rotate Array  
15. Maximum Subarray

Good luck with your prep!  
Mark checkboxes as you master each one — come back and solve again every 2–3 weeks.  
You got this! 🚀
