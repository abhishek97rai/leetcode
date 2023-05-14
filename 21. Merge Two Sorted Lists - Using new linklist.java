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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    ListNode tmp = new ListNode(list1.val);
                    res.next = tmp;
                    res = res.next;
                    list1 = list1.next;
                } else {
                    ListNode tmp = new ListNode(list2.val);
                    res.next = tmp;
                    res = res.next;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                ListNode tmp = new ListNode(list2.val);
                res.next = tmp;
                res = res.next;
                list2 = list2.next;
            } else if (list2 == null) {
                ListNode tmp = new ListNode(list1.val);
                res.next = tmp;
                res = res.next;
                list1 = list1.next;
            }
        }
        return head.next;
    }
}
