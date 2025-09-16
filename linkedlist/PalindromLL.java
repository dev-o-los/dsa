/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Find the middle of the linked list
// Use two pointers: fast moves 2 steps at a time, slow moves 1 step.
// When fast reaches the end, slow will be at the end of the first half.
// Example:
// List: 1 -> 2 -> 2 -> 1
// slow ends at 2 (2nd node). First half = 1,2; Second half = 2,1.
// Reverse the second half of the list
// Reverse nodes after the middle.
// Example: second half 2 -> 1 → becomes 1 -> 2.
// Compare first half and reversed second half
// Start two pointers: one at head, the other at start of reversed second half.
// Compare values until second half ends.
// If all match → palindrome, else not.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }

        ListNode firstHalf = head, secHalf = prev;

        while (secHalf != null) {
            if (firstHalf.val != secHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secHalf = secHalf.next;
        }

        return true;

    }
}