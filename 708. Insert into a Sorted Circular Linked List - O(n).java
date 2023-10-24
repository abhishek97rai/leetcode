/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        newNode.next = newNode;
        if (head == null)
            return newNode;
        Node prev = head;
        Node next = prev.next;
        while (next != head) {
            if ((prev.val <= next.val) && (insertVal >= prev.val && insertVal <= next.val)) {
                insertNode(prev, next, newNode);
                return head;
            } else if (prev.val > next.val && (insertVal <= next.val || insertVal >= prev.val)) {
                insertNode(prev, next, newNode);
                return head;
            } else {
                prev = prev.next;
                next = next.next;
            }
        }
        insertNode(prev, next, newNode);
        return head;
    }

    public void insertNode(Node prev, Node next, Node newNode) {
        newNode.next = next;
        prev.next = newNode;
    }
}
