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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        while (head!=null) {
            st.push(head);
            head = head.next;
        }

        ListNode ans = null;

        int val = Integer.MIN_VALUE;
        while(!st.isEmpty()) {
            ListNode temp = st.pop();
            if (temp.val >= val) {
                val = temp.val;
                if (ans == null) {
                    ans = temp;
                } else {
                    temp.next = ans;
                    ans = temp;
                }

            }
        }

        return ans;
    }
}