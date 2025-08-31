// Initialize variables:
// Create a dummy node dummy = new Node(0).
// Set a pointer curr = dummy (to build the result list).
// Set carry = 0.
// Iterate while l1 != null OR l2 != null OR carry != 0:
// Get x = (l1 != null) ? l1.val : 0.
// Get y = (l2 != null) ? l2.val : 0.
// Compute sum = x + y + carry.
// Update carry = sum / 10
// Create a new node with value sum % 10 and attach it to curr.next.
// Move curr = curr.next.
// Advance l1 and l2 if they are not null.
// After loop ends, return dummy.next (head of result list).

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }
}