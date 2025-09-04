import java.util.Set;
import java.util.TreeSet;

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
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new TreeSet<>();

        while (head != null) {
            set.add(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : set) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}