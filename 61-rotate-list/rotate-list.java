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
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode tail = null;
        ListNode root = head;
        while (root!=null) {
            n++;
            if (root.next == null) {
                tail = root;
            }
            root = root.next;
        }

        if (n>0) {
            k = k%n;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && k>0) {
            k--;
            fast = fast.next;
        }

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow!=null && slow.next!=null) {
            tail.next = head;
            head = slow.next;
            slow.next = null;
        }

        return head;
    }
}