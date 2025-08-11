
//brute force solution

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currStr = new StringBuilder();
            for (int j = i; j < s.length(); j++) {

                if (currStr.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                currStr.append(s.charAt(j));
            }
            maxLength = Math.max(currStr.length(), maxLength);

        }
        return maxLength;
    }
}

// hashmap solution + sliding window
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> visited = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            if (visited.containsKey(currChar) && visited.get(currChar) >= left) {
                left = visited.get(currChar) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visited.put(currChar, right);
        }
        return maxLength;
    }
}

// uses
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            int indexOfFirstOccurInSubstring = s.indexOf(s.charAt(right), left);
            if (indexOfFirstOccurInSubstring != right) {
                left = indexOfFirstOccurInSubstring + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}