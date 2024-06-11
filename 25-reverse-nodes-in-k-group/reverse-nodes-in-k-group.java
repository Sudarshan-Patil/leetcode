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
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        int i=0;
        while (head!=null) {
            ListNode root = head;
            i = 0;
            while (i<k && head != null) {
                head = head.next;
                i++;
            }

            if (i == k) {
                ans.next = reverse(root, null, k);
                ans = root;
            } else {
                ans.next = root;
            }
        }

        return res.next;
    }

    public ListNode reverse(ListNode head, ListNode prev, int k) {
        if (head == null || k == 0) {
            return prev;
        }

        k--;
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;

        return reverse(head, prev, k);
    }
}