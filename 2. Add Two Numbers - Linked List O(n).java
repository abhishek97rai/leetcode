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
        ListNode ptr = res;
        ListNode curr;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
          if (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
          } else if (l1 != null) {
            sum = l1.val + carry;
            l1 = l1.next;
          } else if (l2 != null) {
            sum = l2.val + carry;
            l2 = l2.next;
          }
          curr = new ListNode(sum%10);
          carry = sum/10;
          ptr.next = curr;
          ptr = ptr.next;
        }
        if (carry > 0) {
          curr = new ListNode(carry);
          ptr.next = curr;
        }
        return res.next;
    }
}
