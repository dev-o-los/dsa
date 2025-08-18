import java.util.Arrays;
import java.util.HashSet;

// Algorithm (Sorting Approach)
// If array is empty → return 0.
// Sort the array.
// Initialize longest = 1, current = 1.
// Loop from i = 1 to n-1:
// If duplicate → skip.
// Else if consecutive → current++.
// Else → update longest = max(longest, current) and reset current = 1.
// Return max(longest, current).

// Brute force
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }

        return Math.max(longest, current);

    }
}

// Algorithm
// If empty → return 0.
// Insert all nums into set.
// best = 0. For each x in set:
// If set doesn’t contain x-1:
// len = 1, y = x
// While set contains y+1: y++, len++
// best = max(best, len)
// Return best.

// Optimal approach
class Solution2 {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x); // fast lookup and no duplicates

        int longest = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // x is the start
                int len = 1, y = x;
                while (set.contains(y + 1)) {
                    y++;
                    len++;
                }

                longest = Math.max(longest, len);

            }
        }
        return longest;
    }
}