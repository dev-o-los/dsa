
//brute force
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2)
            return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int area = h * w;
                max = Math.max(max, area);
            }
        }
        return max;
    }
}

// two pointer + greedy

class Solution2 {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2)
            return 0;
        int max = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}