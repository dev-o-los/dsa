
// Algorithm
//     Initialize left = 0, right = 0, maxLength = 0, and maxFreq = 0. Use a frequency array freq of size 26 to store the counts of characters in the current window.
//     Iterate with right from 0 to n-1 to expand the window.
//     For each character s.charAt(right), increment its count in the freq array and update maxFreq with the new maximum frequency in the window.
//     Check the condition: (current window size) - (maxFreq) <= k.
//         The window size is right - left + 1.
//         changesNeeded = (right - left + 1) - maxFreq.
//         If changesNeeded <= k, the current window is a valid candidate. Update maxLength with the current window size (right - left + 1).
//     If changesNeeded > k, the window is invalid. We need to shrink it from the left.
//         Decrement the frequency of the character at s.charAt(left).
//         Increment left by 1.
//         Crucially, we don't need to re-calculate maxFreq for the shrunken window. The window length (right - left + 1) will decrease, and maxFreq will stay the same or decrease. The condition (right - left + 1) - maxFreq <= k will eventually be met again as the window shrinks.
//     Return maxLength after the right pointer has traversed the entire string.

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 0, left = 0, maxFq = 0;
        int[] freq = new int[26];

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFq = Math.max(maxFq, freq[idx]);

            if ((right - left + 1) - maxFq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;
    }

}