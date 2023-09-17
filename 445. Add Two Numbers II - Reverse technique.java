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
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);
        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode();
        ListNode ptr = res;
        ListNode curr;
        while (r1 != null || r2 != null) {
            if (r1 != null && r2 != null) {
                sum = r1.val + r2.val + carry;
                r1 = r1.next;
                r2 = r2.next;
            } else if (r1 != null) {
                sum = r1.val + carry;
                r1 = r1.next;
            } else if (r2 != null) {
                sum = r2.val + carry;
                r2 = r2.next;
            }
            curr = new ListNode(sum%10);
            ptr.next = curr;
            ptr = ptr.next; 
            carry = sum/10;
        }
        if (carry > 0) {
            curr = new ListNode(carry);
            ptr.next = curr;
        }
        return reverseList(res.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
