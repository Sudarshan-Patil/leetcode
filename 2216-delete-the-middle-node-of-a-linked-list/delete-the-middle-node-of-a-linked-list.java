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
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head;

        while (next!=null && next.next!=null) {
            next = next.next.next;
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            return prev;
        }

        if (prev!=null && prev.next!=null) {
            prev.next = prev.next.next;
        }

        return head;
    }
}