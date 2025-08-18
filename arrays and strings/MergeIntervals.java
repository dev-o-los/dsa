import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

// Algorithm:

// For each interval, compare it with every other interval.
// If intervals overlap → merge them.
// Keep merging until no further merges are possible.
// This is like repeatedly collapsing overlapping intervals.
// Overlap Condition:
// Two intervals [a,b] and [c,d] overlap if:

// Complexity:
// Time: O(N^2) (due to sorting).
// Space: O(N) (for result list).

//Brute force
class Solution {
    public int[][] merge(int[][] intervals) {
        // conv array to list
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        boolean merged = true;
        while (merged) {
            merged = false;
            outer: for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    // Check overlap: b.start <= a.end && a.start <= b.end
                    if (b[0] <= a[1] && a[0] <= b[1]) {
                        int start = Math.min(a[0], b[0]);
                        int end = Math.max(a[1], b[1]);
                        list.remove(j);
                        list.remove(i);
                        list.add(new int[] { start, end });
                        merged = true;
                        break outer; // restart checking since list changed
                    }
                }
            }
        }
        // conv list to array
        return list.toArray(new int[list.size()][]);
    }
}

// Algorithm:
// Sort intervals by start time.
// Create a result list.
// Add the first interval into result.
// For each next interval:
// If it overlaps with the last added interval → merge them.
// Otherwise, just add it to result.
// Done.

// Complexity:
// Time: O(N log N) (due to sorting).
// Space: O(N) (for result list).

// Optimal Approach
class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort the array by start index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        res.add(current);

        // Traverse
        for (int[] interval : intervals) {
            // Check for overlap
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                res.add(current);
            }
        }
        // conv list to array
        return res.toArray(new int[res.size()][]);
    }
}