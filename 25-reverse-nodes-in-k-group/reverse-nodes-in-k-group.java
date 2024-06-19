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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode root = head;
        ListNode ans = reverse(root, null, root, k);
        
        while (true) {
            ListNode temp = head;
            head = head.next;
            int i=0;
            while (i<k && head != null) {
                head = head.next;
                i++;
            }

            if (i<k && head==null) {
                break;
            }
            
            head = temp.next;
            temp.next = reverse(temp.next, null, temp.next, k);
        }
                
        return ans;
    }

    public ListNode reverse(ListNode head, ListNode prev, ListNode old, int k) {
        if (head == null) {
            return prev;
        }

        if (k==0) {
            old.next = head;
            return prev;
        }
        k--;

        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;

        return reverse(head, prev, old, k);
    }
}