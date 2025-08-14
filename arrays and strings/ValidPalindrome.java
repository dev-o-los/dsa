//optimal

// Optimal Approach – Two Pointers (O(1) extra space)

// Key Insight:
// We don’t actually need to create new strings.
// We can:

// Use two pointers: one starting at beginning (left), one at end (right).

// Move them toward each other:

// Skip characters that are not alphanumeric.

// Compare characters (case-insensitive).

// If mismatch → return false.

// If pointers meet without mismatches → true.
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;

    }
}
// Why Brute Force is Bad:

// Time complexity: O(n) for cleaning + O(n) for reversing → O(n), which is
// fine.

// But extra space: We store the cleaned string and reversed string → O(n) extra
// memory.

// We can do this in-place using two pointers without building a new string.
// brut force
public class ValidPalindrome {

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";

        StringBuilder str = new StringBuilder(a.replaceAll("[^a-zA-Z0-9]", ""));

        System.out.println(str.toString() + " " + str.reverse().toString());
        System.out.println(str.toString() == str.reverse().toString());

    }
}
