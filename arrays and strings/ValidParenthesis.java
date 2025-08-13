
// Idea:

// We repeatedly remove "()", "{}", and "[]" from the string until:

//     The string becomes empty → valid

//     No changes can be made, but string still not empty → invalid

// Code (Java, brute force, O(n²) worst case)

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        boolean changed = true;
        while (changed) {
            int prevLength = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
            changed = prevLength != s.length();
        }

        return s.isEmpty();
    }
}

// We need to check if brackets are properly nested.
// This is exactly what a stack is made for:

// Push opening brackets onto the stack.

// When a closing bracket appears:

// If stack is empty → invalid

// Pop from the stack and check if it matches the closing bracket.

// At the end, if stack is empty → valid.

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("()[]{}")); // true
        System.out.println(vp.isValid("(]")); // false
        System.out.println(vp.isValid("{[]}")); // true
    }
}
