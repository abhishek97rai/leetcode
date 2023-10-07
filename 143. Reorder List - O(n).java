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
    public void reorderList(ListNode head) {
        //step 1 - reverse the 2nd half of the linked list
        //step 1-1 - reach middle element
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        //step 1-2 - reverse from middle element
        ListNode rev = reverseList(second);
        //step 2 - keep iterating and arranging nodes as required until right pointer is not null
        ListNode first = head;
        while (rev != null) {
            ListNode next1 = first.next;
            ListNode next2 = rev.next;
            first.next = rev;
            rev.next = next1;
            first = next1;
            rev = next2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
