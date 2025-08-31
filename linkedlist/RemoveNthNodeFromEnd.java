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

// Find the total length of list (say len).
// Compute position from start = len - n.
// Traverse again to that position and delete node.
// Time Complexity: O(2n).
// Space: O(1).

class Solution {
    int getLength(ListNode node) {
        int count = 0;
        ListNode curr = node;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int pos = getLength(head) - n;

        if (pos == 0) {
            head = head.next;
            return head;
        } else {

            ListNode curr = head;
            for (int i = 1; curr != null && i < pos; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;

            return head;
        }
    }

}

// Use the two-pointer technique:
// Create a dummy node before head (to handle edge cases like removing the first
// node).
// Move fast pointer n+1 steps ahead.
// Move both fast and slow together until fast reaches the end.
// slow.next will now point to the node to be deleted.
// Skip it: slow.next = slow.next.next.
// This way, we only traverse the list once.

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}