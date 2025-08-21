
//Brute force
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int[] res = new int[n];

        for (int self = 0; self < n; self++) {
            // go to right side from the self index and keep track of prod
            if (self < n) {
                for (int i = self + 1; i < n; i++) {
                    prod *= nums[i];
                }
            }
            // go to left side from the self index and keep track of prod
            if (self > 0) {
                for (int i = self - 1; i >= 0; i--) {
                    prod *= nums[i];
                }

            }
            // save the value in the array
            res[self] = prod;
            // and reset prod for next self
            prod = 1;
        }

        return res;

    }
}

// Create an output array res of size n.
// First pass (left to right):
// For each index i, store the product of all elements before it in res[i].
// Example: res[i] = nums[0] * nums[1] * ... * nums[i-1].
// Second pass (right to left):
// Keep a running variable suffixProduct.
// Multiply res[i] with suffixProduct to also include the product of all
// elements after it.
// Update suffixProduct *= nums[i].
// Finally, res[i] will have the product of all elements except nums[i].

// Optimal approach
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;

    }
}