
//Algo
// for i in 0..n-1:
//     product = 1
//     for j in i..n-1:
//         product *= nums[j]
//         update max

//Brute force
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currProduct = 1; // reset product for each new starting point
            for (int j = i; j < n; j++) {
                currProduct *= nums[j]; // extend subarray
                maxProduct = Math.max(currProduct, maxProduct);
            }
        }
        return maxProduct;
    }
}

// Optimal 1
// Algorithm(Optimized DP approach)
// We use two variables:
// currMax → max product ending at index i
// currMin → min product ending at index i (because a negative number can
// flip)
// At every index:
// If nums[i] < 0, swap currMax and currMin
// Update:
// currMax = max(nums[i], currMax * nums[i])
// currMin = min(nums[i], currMin * nums[i])
// Update global maximum:
// maxProd = max(maxProd, currMax)

class Solution2 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int currMax = nums[0], currMin = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(curr, currMax * curr);
            currMin = Math.min(curr, currMin * curr);

            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }
}

// Algorithm
// Initialize maxProduct = Integer.MIN_VALUE.
// Do a left-to-right scan:
// Keep product.
// If product == 0, reset to 1.
// Update maxProduct.
// Do a right-to-left scan (same logic).
// Return maxProduct.

// Optimal 2
class Solution3 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        // left to right product
        int prod = 1;
        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            maxProd = Math.max(prod, maxProd);
            if (nums[i] == 0)
                prod = 1; // reset to 1;
        }

        prod = 1;
        // right to left product
        for (int i = n - 1; i >= 0; i--) {
            prod *= nums[i];
            maxProd = Math.max(prod, maxProd);
            if (nums[i] == 0)
                prod = 1; // reset to 1;
        }

        return maxProd;
    }
}