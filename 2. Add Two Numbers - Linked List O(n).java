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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ctr = res;
        int sum = 0;
        int quot = 0;
        ListNode cur;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + quot;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + quot;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val + quot;
                l2 = l2.next;
            }
            if (sum < 10) {
                cur = new ListNode(sum);
                quot = 0;
            } else {
                quot = sum/10;
                int rem = sum - quot*10;
                cur = new ListNode(rem);
            }
            ctr.next = cur;
            ctr = ctr.next;
        }
        if (quot != 0) {
            cur = new ListNode(quot);
            ctr.next = cur;
            ctr = ctr.next;
        }
        return res.next;
    }
}
