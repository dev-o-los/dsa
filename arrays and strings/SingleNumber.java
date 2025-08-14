
//Brute force solution

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums) {
            if (map.get(n) == 1)
                return n;
        }

        return -1;

    }
}

// Optimal Solution — XOR Trick (O(n) time, O(1) space)
// Key Insight

// a ^ a = 0 → same numbers cancel each other out.

// a ^ 0 = a

// XOR is commutative and associative, so order doesn’t matter.

// If you XOR all numbers, all pairs vanish, and only the single number remains.

// Step by step:

// Start with result = 0

// 0 ^ 4 = 4

// 4 ^ 1 = 5 (not important what it becomes, just keep going)

// 5 ^ 2 = 7

// 7 ^ 1 — since 1 appeared earlier, it will cancel out its effect later:

// Remember: XOR with same number twice removes it.

// 6 ^ 2 = 4 → the lonely number remains.

// Every pair disappears, only the single one survives.

// Optimal approach
class Solution2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        return res;

    }
}