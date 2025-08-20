
//Algo
//We will use two pointer approach
//add the numbers at the pointers
// if sum > target move last pointer towards left to get smaller sum
//since numbers are sorted
//this is the fastest method

//Optimal approach
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return numbers;
    }
}