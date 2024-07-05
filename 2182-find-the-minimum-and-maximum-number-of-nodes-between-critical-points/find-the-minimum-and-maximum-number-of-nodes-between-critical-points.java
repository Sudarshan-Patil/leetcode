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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{-1, -1};
        ListNode prev = head;
        head = head.next;

        ArrayList<Integer> temp = new ArrayList<>();
        int idx = 2;
        while (head.next != null) {
            if (head.val < prev.val && head.val < head.next.val) {
                temp.add(idx);
            }
            if (head.val > prev.val && head.val > head.next.val) {
                temp.add(idx);
            }

            prev = head;
            head = head.next;
            idx++;
        }

        if (temp.size() <= 1) {
           return ans; 
        }

        Collections.sort(temp);

        ans[1] = temp.get(temp.size()-1) - temp.get(0);

        int t = Integer.MAX_VALUE;
        for (int i=1; i<temp.size(); i++) {
            t = Math.min(t, temp.get(i)-temp.get(i-1));
        }
        ans[0] = t;

        return ans;
    }
}