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

    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null) {
            return head;
        }

        ListNode root = head;
        ListNode middle = getMiddle(head);

        if (middle!=null) {
            ListNode temp = middle.next;
            middle.next =null;
            middle = temp;
        }

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(middle);

        return mergeSortedList(l1, l2);
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast!=null && fast.next!=null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        return prev;
    }

    public ListNode mergeSortedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null ){
            return l1;
        }

        ListNode head = null;

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        head.next = mergeSortedList(l1, l2);

        return head;
    }
}