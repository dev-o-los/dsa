import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//brute force solution

class Solution {

    public boolean containsDuplicate(int[] nums) {
        // This line of code is converting an array of integers `nums` into a List of
        // Integers.
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int n : nums) {

            // If these two indexes are not equal, it means that there are duplicate
            // occurrences of the
            // element `n` in the list, and in that case, the method returns `true`
            // indicating that the
            // array contains duplicates.
            if (list.indexOf(n) != list.lastIndexOf(n)) {
                return true;
            }

        }

        return false;
    }
}

// optimal
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int n : nums) {
            if (!seen.add(n))
                return true;
        }
        return false;
    }
}