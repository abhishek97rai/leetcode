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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode second = head.next;
        ListNode odd = head;
        ListNode even = second;
        boolean isEven = false;
        while (even != null && !isEven) {
            if (even.next == null) {
                odd.next = second;
                isEven = true;
            } else {
                odd.next = even.next;
                even.next = odd.next.next;
                even = even.next;
                odd = odd.next;
            }
        }
        if (!isEven)
            odd.next = second;
        return head;
    }
}
