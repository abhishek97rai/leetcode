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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else {
            ListNode ctr = head;
            head = head.next;
            ListNode prev = new ListNode();
            while (ctr != null) {
                if (ctr.next != null) {
                    ListNode sec = ctr.next;
                    ctr.next = sec.next;
                    sec.next = ctr;
                    prev.next = sec;
                }
                prev = ctr;
                ctr = ctr.next;
            }
            return head;
        }
    }
}
