import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//brute force
class Solution {
    public int missingNumber(int[] nums) {
        // conv array to list
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        // check each num in range [0,n]
        for (int i = 0; i <= nums.length; i++) {
            // if not present return i;
            if (!list.contains(i))
                return i;
        }

        return 0;

    }
}

// Approach 1
// Idea: If we sort the array, the numbers should appear in order 0, 1, 2, …, n.
// If any number is missing, it will show up as a mismatch at some index.

// Steps:

// Sort the array.

// Traverse from 0 → n-1.

// If nums[i] != i, then i is the missing number.

// If everything matches, the missing number is n.
class Solution1 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;

    }
}

// Approach 2
// Idea: Put all numbers into a set, then check which number 0 → n is missing.

// Steps:

// Insert all nums into a HashSet.

// Iterate 0 → n.

// The number not in the set is the answer.
class Solution2 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i))
                return i;
        }

        return nums.length;

    }
}

// Approach 3 (Best but can have overflow issue)
// Idea (Why it works):

// The sum of first n numbers is:

// total=n×(n+1)/2
// total=n×(n+1)/2

// But since one number is missing, the sum of nums will be smaller.

// Missing number = expectedSum – actualSum.
class Solution3 {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actual = 0;
        for (int num : nums)
            actual += num;
        return expectedSum - actual;
    }
}

// Approach 4 (Best)
class Solution4 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        // XOR with all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        // XOR with all numbers in nums
        for (int num : nums) {
            xor ^= num;
        }
        // since XOR is a pair cancellor , we will get the missing number
        return xor;
    }
}