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

// Idea:

// Maintain 2 pointers:
// prev (initially null)
// curr (initially head)
// next (temporary to store curr.next)

// Steps:
// Save next = curr.next
// Reverse link → curr.next = prev
// Move forward: prev = curr, curr = next
// At the end, prev = new head

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}