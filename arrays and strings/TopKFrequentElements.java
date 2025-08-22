import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Algorithm Steps
    Create a HashMap to store the frequency of each number in the input array nums.
    Iterate through nums and populate the map. For each number, increment its count.
    Create a List containing all the unique numbers (the keys from the map).
    Sort this list using a custom comparator that compares two numbers based on 
    their frequencies stored in the map. The sort order should be descending.
    Create a result array of size k and copy the first k elements from the sorted list into it.

    Return the result array.
 */

//Brute force
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(freqMap.keySet());
        uniqueNums.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = uniqueNums.get(i);
        }

        return res;

    }
}

// Algorithm Steps

// Create a HashMap to store the frequency of each number.

// Create a Min-Heap (PriorityQueue) that will store numbers. The heap's
// comparison logic will be based on the frequencies stored in the map.

// Iterate through the unique numbers (the keys of the map). For each number:
// a. Add the number to the min-heap.
// b. If the heap's size exceeds k, remove the element at the top of the heap
// (poll()). This discards the number with the lowest frequency among the
// current k+1 candidates.

// After iterating through all numbers, the heap will contain exactly the k most
// frequent elements.

// Extract all elements from the heap into a result array and return it.

// Optimal 1 (Best approach)
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for (int num : freqMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // Removes the element with smallest freq
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;

    }
}

// Create a HashMap to store the frequency of each number in nums.
// Create an array of lists, buckets, of size nums.length + 1. buckets[i] will
// store the numbers that have a frequency of i.
// Iterate through the frequency map. For each number num with frequency freq,
// add num to buckets[freq].
// Create a result list.
// Iterate through the buckets array from the last index down to the first.
// a. If a bucket at a given index is not empty, add all its numbers to the
// result list.
// b. Stop once the result list contains k elements.
// Convert the result list to an array and return it.

// Optimal 2
class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int counter = 0;
        for (int i = buckets.length - 1; i >= 0 && counter < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[counter++] = num;
                }
            }
        }

        return res;

    }
}