import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
// Traverse both lists and collect all values into an array or ArrayList.
// Sort the array.
// Create a new linked list from sorted values
// Time Complexity:
// Collect values → O(m+n)
// Sorting → O((m+n) log(m+n))
// Constructing new list → O(m+n)
// Overall → O((m+n) log(m+n))
// Space Complexity: O(m+n) (extra space for storing values).

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> vals = new ArrayList<>();

        while (list1 != null) {
            vals.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            vals.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(vals);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}

// Idea:
// Since both lists are already sorted, we don’t need to collect and sort.
// We can merge them in-place like the merge step of merge sort.
// Use a dummy node to simplify handling.
// Compare l1.val and l2.val.
// Attach the smaller node to the result list.
// Move that list’s pointer forward.
// Continue until one list is empty.
// Attach the remaining part of the other list.
// Time Complexity: O(m+n)
// Space Complexity: O(1) (in-place merging, only using pointers).

class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;
        if (list2 != null)
            curr.next = list2;

        return dummy.next;
    }
}