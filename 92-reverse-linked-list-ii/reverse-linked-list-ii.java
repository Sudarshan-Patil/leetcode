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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = head;
        ListNode prev = null;
        int i=1;
        while (i<left) {
            prev = head;
            head = head.next;
            i++;
        }

        right = right-left;

        if (prev == null) {
            return reverse(head, null, head, right);
        } else {
            prev.next = reverse(head, null, head, right);
        }

        return root;
    }

    public ListNode reverse(ListNode head, ListNode prev, ListNode old, int r) {
        if (head == null || r<0) {
            if (r < 0) {
                old.next = head;
            }
            return prev;
        }

        r--;

        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;

        return reverse(head, prev, old, r);
    }
}