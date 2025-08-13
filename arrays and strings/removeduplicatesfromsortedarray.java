// 3. Optimal approach (Two-pointer method)

// We can do it in one pass using two pointers:

//     i → pointer for placing the next unique element.

//     j → pointer for scanning the array.

// Algorithm:

//     Start with i = 0.

//     Loop j from 1 to nums.length - 1.

//     If nums[j] is different from nums[i]:

//         Increment i (move to next position).

//         Copy nums[j] to nums[i].

//     At the end, the new length = i + 1.

class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {

            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }
}