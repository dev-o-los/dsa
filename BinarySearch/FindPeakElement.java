
// Initialize two pointers:

// low = 0 (start of array)
// high = nums.length - 1 (end of array)
// Repeat while low < high:
// a. Compute mid = low + (high - low) / 2.
// b. Compare nums[mid] with nums[mid + 1]:
// If nums[mid] < nums[mid + 1]:
// → The peak must be on the right side, so set low = mid + 1.
// Else (nums[mid] >= nums[mid + 1]):
// → The peak must be on the left side or at mid, so set high = mid.
// When the loop ends (low == high), both pointers point to the same index.
// Return low (or high, both are same).

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}