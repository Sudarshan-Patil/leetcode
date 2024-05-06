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
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current!=null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        ListNode old = null;
        current = prev.next;
        prev.next = null;

        while (current != null) {
            if (current.val < prev.val) {
                current = current.next;
            } else {
                ListNode temp = current.next;
                current.next = prev;
                prev.next = old;
                old = prev;
                prev = current;
                current = temp;
            }
        }

        return prev;
    }
}