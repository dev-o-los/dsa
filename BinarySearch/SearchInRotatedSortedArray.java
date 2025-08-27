// Optimal Binary Search (O(log n))
// Algorithm
// Use binary search with two pointers low and high.
// Find mid = (low + high) / 2.
// If nums[mid] == target, return mid.
// Check which half is sorted:
// If nums[low] <= nums[mid] → left side is sorted.
// If target lies in this range → search left.
// Else search right.
// Else → right side is sorted.
// If target lies in this range → search right.
// Else search left.
// If not found, return -1.

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}