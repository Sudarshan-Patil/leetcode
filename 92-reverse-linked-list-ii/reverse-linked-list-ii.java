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
        if (left == right) {
            return head;
        }

        ListNode root = head;
        ListNode prev = null;
        int i=1;
        while (i<left) {
            prev = root;
            root = root.next;
            i++;
        }

        if (prev == null) {
            return reverse(root, null, root, i, right);
        } else {
            prev.next = reverse(root, prev, prev.next, i, right);
        }

        return head;
    }

    public ListNode reverse(ListNode current, ListNode prev, ListNode first, int i, int right) {
        if (i > right || current == null) {
            first.next = current;
            return prev;
        }

        ListNode temp = current.next;
        current.next = prev;

        return reverse(temp, current, first, i+1, right);
    }
}