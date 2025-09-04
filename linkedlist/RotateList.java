/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Brute force
class Solution {

    public int getLength(ListNode head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }

        return c;
    }

    public ListNode rotate(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        curr.next = head;
        prev.next = null;

        return curr;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        int length = getLength(head);
        k = k % length;

        for (int i = 0; i < k; i++) {
            head = rotate(head);
        }

        return head;
    }
}