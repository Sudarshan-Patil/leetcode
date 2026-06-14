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
    public int pairSum(ListNode head) {
        ListNode root = new ListNode(head.val);
        ListNode newNode = root;
        ListNode node = head;
        head = head.next;

        while (head!=null) {
            ListNode temp = new ListNode(head.val);
            root.next = temp;
            root = temp;
            head = head.next;
        }

        head = node;
        head = reverse(head, null);

        int ans = 0;
        while (head!=null && newNode!=null) {
            ans = Math.max(ans, head.val+newNode.val);
            head = head.next;
            newNode = newNode.next;
        }

        return ans;
    }

    public ListNode reverse(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return head;
        }

        ListNode temp = head.next;
        head.next = prev;
        return reverse(temp, head);
    }
}