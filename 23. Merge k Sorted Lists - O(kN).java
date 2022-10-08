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
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            int min_index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        min_index = i;
                    }
                    isBreak = false;
                }
            }
            if (isBreak)
                break;
            ptr.next = lists[min_index];
            ptr = ptr.next;
            lists[min_index] = lists[min_index].next;
        }
        return head.next;
    }
    
}
