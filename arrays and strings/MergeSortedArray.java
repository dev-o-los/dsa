// Idea:
// Since both arrays are already sorted, we can merge them like in merge sort’s merge step without sorting again.

// The trick:

//     Instead of merging from the front (which causes overwriting), merge from the back.

//     Start from the last index of nums1 and fill it with the larger of the last elements from nums1’s valid part and nums2.

//     Move backwards until all nums2 elements are placed.

// Steps

//     Let i = m-1 → last valid index in nums1.

//     Let j = n-1 → last index in nums2.

//     Let k = m+n-1 → last index in nums1 (including empty space).

//     While j >= 0:

//         If nums1[i] > nums2[j], put nums1[i] in nums1[k], i--.

//         Else, put nums2[j] in nums1[k], j--.

//         k-- every time.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}