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
        if (k==0 || head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode root = head;
        ListNode tail = null;
        while (head!=null) {
            tail = head;
            head = head.next;
            n++;
        }

        k = k%n;
        if (k==0) {
            return root;
        }
        
        k = n-k;
        ListNode prev = null;
        head = root;
        while (k > 0) {
            prev = head;
            head = head.next;
            k--;
        }

        prev.next = null;
        tail.next = root;

        return head;
    }
}