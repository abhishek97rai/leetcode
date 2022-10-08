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
        List<Integer> list = new ArrayList<Integer>();
        for (ListNode node: lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        //System.out.println(list);
        Collections.sort(list);
        
        //dummy to point to actual result LL
        ListNode init = new ListNode(0);
        ListNode ptr = init;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            ptr.next = node;
            ptr = ptr.next;
        }
        return init.next;
    }
    
}
