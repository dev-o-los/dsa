package BinarySearch;

// Optimal Solution (Binary Search, O(log n))

// In a rotated sorted array, one part is always sorted.
// If the array is already sorted (nums[low] < nums[high]), then nums[low] is
// the minimum.
// Otherwise, use binary search
// Compute mid.
// If nums[mid] >= nums[low], then left part is sorted → min must be in right
// part → move low = mid + 1.
// Else, min must be in left part → move high = mid.
// Eventually low == high, which is the index of the minimum element.

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If right half is sorted, minimum is in left half (including mid)
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                // Minimum is in right half
                low = mid + 1;
            }
        }

        // low == high is the minimum element index
        return nums[low];
    }
}
