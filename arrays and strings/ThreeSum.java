
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Steps
// Loop through the array, fixing the first number (i).
// For each i, solve a 2Sum problem for the remaining numbers (i+1 → n-1), where the target = -nums[i].
// Use a HashMap to store seen numbers while solving this 2Sum.
// If we find a pair that satisfies the condition, add the triplet to the result.
// To avoid duplicates, we can use a Set.

//Brute force
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int target = -nums[i]; // target for 2Sum
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int complement = target - nums[j];
                if (map.containsKey(complement)) {
                    // Found triplet
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet); // sort to handle duplicates
                    result.add(triplet);
                }
                map.put(nums[j], j); // store the number
            }
        }

        return new ArrayList<>(result);
    }

}

// Idea
// After sorting, fixing one number nums[i] turns the rest into a 2Sum problem
// on a sorted array.
// In a sorted array, 2Sum can be solved with two pointers in linear time:
// If the sum is too small → move left rightward (need larger numbers).
// If the sum is too big → move right leftward (need smaller numbers).
// Skip equal numbers to avoid duplicate triplets.

// Best approach
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break; // no more solutions possible

            int left = i + 1, right = n - 1;
            while (left < right) {
                int s = nums[i] + nums[left] + nums[right];

                if (s == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                } else if (s < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return res;

    }
}