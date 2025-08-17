
// Best approach (Kadane's algo)
class Solution {
    public static int maxSubArray(int[] nums) {
        // assume nums.length >= 1 (LeetCode guarantees at least one element)
        int current = nums[0]; // best subarray sum ending at index 0
        int max = nums[0]; // best overall sum so far

        for (int i = 1; i < nums.length; i++) {
            // recurrence: either start fresh at nums[i] or extend previous
            current = Math.max(nums[i], current + nums[i]);

            // update global best
            max = Math.max(max, current);
        }

        return max;
    }
}

// Algorithm
// Initialize maxSum = -∞ (or Integer.MIN_VALUE).
// Loop through all possible starting indices i.
// For each i, loop through ending indices j (>= i).
// Compute sum of subarray nums[i..j].
// Update maxSum if current sum is greater.
// Return maxSum.

class Solution1 {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j]; // add next element
                maxSum = Math.max(maxSum, currentSum); // update max
            }
        }
        return maxSum;
    }
}