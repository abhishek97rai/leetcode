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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }
        if (len == n)
            return head.next;
        int k = 0;
        ListNode sec = head;
        while (k != len-n-1) {
            sec = sec.next;
            k++;
        }
        sec.next = sec.next.next;
        return head;
    }
}
