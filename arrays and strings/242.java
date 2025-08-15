import java.util.Arrays;

//brute force approach
class Solution {
    public boolean isAnagram(String s, String t) {
        // length will be always same for s and t
        if (s.length() != t.length())
            return false;

        // conv to arr
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        // sort them
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        // if they are same then its a anagram
        return Arrays.equals(sarr, tarr);
    }
}

// Idea:

// Make an array of size 26 (for lowercase English letters).
// Increment counts for each character in s.
// Decrement counts for each character in t.
// If all counts are zero → anagram.

// optimal approach
class Solution2 {
    public boolean isAnagram(String s, String t) {
        // length will be always same for s and t
        if (s.length() != t.length())
            return false;
        // fixed count arr
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray())
            count[c - 'a']--;
        for (int n : count)
            if (n != 0)
                return false;

        return true;

    }
}