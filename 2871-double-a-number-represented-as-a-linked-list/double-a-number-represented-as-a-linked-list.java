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
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        int carry = getDouble(head);

        if (carry > 0) {
            ListNode root = new ListNode(carry);
            root.next = head;
            return root;
        }
        
        return head;
    }

    public int getDouble(ListNode head) {
        if (head == null) {
            return 0;
        }

        int carry = getDouble(head.next);

        int temp = head.val * 2 + carry;

        head.val = temp%10;

        return temp/10;
    }
}