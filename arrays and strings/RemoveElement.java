
// Optimized solution — Two-pointer technique

// Here’s the grown-up way to think:

//     We don’t need to "shift" multiple times. We can overwrite in one pass.

//     Use one pointer i to scan every element.

//     Use another pointer k to mark the next position to write a valid element (not equal to val).

// Steps:

//     Initialize k = 0.

//     Loop i from 0 to n:

//         If nums[i] != val → write it to nums[k] and increment k.

//     At the end, k will be the count of valid elements, and the first k spots contain the answer.

class Solution {
   public int removeElement(int[] nums, int val) {
      int k = 0;
      for (int i = 0; i < nums.length; i++) {
         if (val != nums[i]) {
            nums[k] = nums[i];
            k++;
         }
      }
      return k;
   }
}