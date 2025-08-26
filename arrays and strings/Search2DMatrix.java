
// Algorithm

// Let rows = matrix.length, cols = matrix[0].length.
// Treat the 2D matrix as a 1D sorted array of size rows * cols.
// Set low = 0, high = rows * cols - 1.
// While low <= high:
// a. Compute mid = low + (high - low) / 2.
// b. Map back to 2D: i = mid / cols, j = mid % cols.
// c. If matrix[i][j] == target, return true.
// d. If matrix[i][j] > target, move left → high = mid - 1.
// e. Else move right → low = mid + 1.

// If loop ends, return false.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / cols;
            int j = mid % cols;
            int num = matrix[i][j];

            if (num == target) {
                return true;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
