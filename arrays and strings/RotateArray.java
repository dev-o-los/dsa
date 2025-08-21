
// Algorithm
// Let n = nums.length. If n == 0 return.
// Set k = k % n. If k == 0 return.
// Repeat k times:
// tmp = nums[n-1]
// For i from n-1 down to 1: nums[i] = nums[i-1]
// nums[0] = tmp
// Time: O(n * k)
// Space: O(1)

//Brute force
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        int n = nums.length;
        k = k % n; // to keep the value of k within range n
        if (k == 0)
            return;

        for (int step = 0; step < k; step++) {
            int last = nums[n - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
        }
    }
}

// Rotate nums to the right by k steps.
// Mathematically, every element at index i should end up at (i + k) % n.
// so we can just use extra space and create a new array and copy it back
// Time: O(n)
// Space: O(n)

class Solution2 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}

// Algorithm
// n = nums.length; if n == 0 return.
// k = k % n; if k == 0 return.
// Reverse nums[0..n-1].
// Reverse nums[0..k-1].
// Reverse nums[k..n-1].
// Time: O(n)
// Space: O(1)

// Optimal approach
class Solution3 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}