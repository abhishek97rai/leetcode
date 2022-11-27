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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode ptr = head;
        List<Integer> list = new ArrayList<>();
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }
        ListNode res = new ListNode(list.get(list.size()-1));
        ListNode ctr = res;
        for (int i = list.size()-1; i > 0; i--) {
            ctr.next = new ListNode(list.get(i-1));
            ctr = ctr.next;
        }
        return res;
    }
}
