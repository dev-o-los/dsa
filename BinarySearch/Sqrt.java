package BinarySearch;
// Algorithm

// If x == 0 or x == 1, return x (because √0 = 0, √1 = 1).
// Start a loop from i = 1 up to x.
// For each i, check if i * i <= x.
// Stop when i * i > x and return i - 1.

//Brute force
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int i = 1;
        while (i <= x) {
            if ((i * i) == x)
                return i;
            if ((i * i) > x)
                return i - 1;
            i++;
        }

        return -1;
    }
}

// Idea
// We want the largest integer r such that r² ≤ x.
// Instead of linearly checking, use binary search:
// Low = 1, High = x
// Compute mid = (low + high) / 2
// If mid * mid == x, return mid
// If mid * mid < x, move right (low = mid + 1)
// If mid * mid > x, move left (high = mid - 1)
// Finally, return high (the largest valid integer).

// Algorithm
// Handle base case x == 0 or x == 1.
// Set low = 1, high = x / 2 (√x can’t be bigger than x/2 for x > 1).
// While low <= high:
// Compute mid = (low + high) / 2.
// If mid * mid == x, return mid.
// If mid * mid < x, move low = mid + 1.
// Else, high = mid - 1.
// Return high.

// Optimal approach

class Solution2 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int low = 1, high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow
            if ((long) mid * mid == x)
                return mid;
            else if ((long) mid * mid < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}