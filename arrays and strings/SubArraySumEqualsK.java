import java.util.HashMap;

// Initialize count to 0, which will store the number of valid subarrays.
// Initialize currSum to 0, which will keep track of the running sum of the array as we iterate through it.
// Create a HashMap called map to store the frequency of each prefix sum encountered so far.
// Add (0, 1) to the map. This handles the case where a subarray starting from index 0 has a sum equal to k.
// Iterate through each number n in the input array nums:
//     Add n to currSum.
//     Calculate the target prefix sum needed to get a subarray sum of k: target = currSum - k.
//     Check if target exists as a key in the map. If it does, add its frequency to count. This is because any time we've seen this target prefix sum before, 
//     it means there's a valid subarray ending at the current position.
//     Update the map by incrementing the frequency of the current currSum. If currSum isn't in the map, add it with a frequency of 1.
// Return count.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : nums) {
            currSum += n;
            count += map.getOrDefault((currSum - k), 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}