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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans = head.next;
        swap(head, null);
        return ans;
    }

    public void swap(ListNode head, ListNode prev) {
        if (head == null || head.next == null) {
            return ;
        }

        ListNode root = head.next;
        ListNode temp = head.next.next;
        root.next = head;
        head.next = temp;

        if (prev != null) {
            prev.next = root;
        }
        prev = head;
        swap(temp, prev);

        return;
    }
}