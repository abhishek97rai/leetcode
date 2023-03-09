/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random == null)
                temp.next.random = null;
            else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = temp.next;
        Node temp2 = newHead;
        while (temp != null) {
            temp.next = temp2.next;
            if (temp.next != null)
                temp2.next = temp.next.next;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}
