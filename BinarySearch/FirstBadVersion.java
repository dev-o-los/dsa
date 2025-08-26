package BinarySearch;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Idea:

// Because once a version is bad, all later versions are bad → monotonic property.
// We can use binary search:
// Search space: [1, n].
// Check middle version mid.
// If isBadVersion(mid) is true → first bad version is at mid or before.
// Else → first bad version is after mid.
// Algorithm:
// Initialize low = 1, high = n.
// While low < high:
// Compute mid = low + (high - low) / 2 (to avoid overflow).
// If isBadVersion(mid) is true → move high = mid.
// Else → move low = mid + 1.
// Return low (or high), because both will point to the first bad version.

class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}