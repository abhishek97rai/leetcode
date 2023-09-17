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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode();
        ListNode ptr = res;
        ListNode curr;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum = s1.pop() + s2.pop() + carry;
            } else if (!s1.isEmpty()) {
                sum = s1.pop() + carry;
            } else if (!s2.isEmpty()) {
                sum = s2.pop() + carry;
            }
            s3.push(sum%10);
            carry = sum/10;
        }
        if (carry > 0) {
            s3.push(carry);
        }
        while (!s3.isEmpty()) {
            curr = new ListNode(s3.pop());
            ptr.next = curr;
            ptr = ptr.next;
        }
        return res.next;
    }

}
