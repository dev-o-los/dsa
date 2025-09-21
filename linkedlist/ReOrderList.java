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
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        //Findind mid of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next;
        slow.next = null;//split into two halves;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        //Merge two halved alternately
        ListNode t1 = head, t2 = prev;
        while (t2 != null) {
            ListNode m1 = t1.next, m2 = t2.next;
            t1.next = t2;
            t2.next = m1;

            t1 = m1;
            t2 = m2;

        }

    }
}