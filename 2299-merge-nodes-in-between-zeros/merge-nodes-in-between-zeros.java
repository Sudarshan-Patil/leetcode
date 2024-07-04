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
    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode ans = root;
        head = head.next;
        while (head!=null) {
            int temp = 0;
            while (head!=null && head.val!=0) {
                temp += head.val;
                head = head.next;
            }
            root.next = new ListNode(temp);
            root = root.next;
            head = head.next;
        }

        return ans.next;
    }
}