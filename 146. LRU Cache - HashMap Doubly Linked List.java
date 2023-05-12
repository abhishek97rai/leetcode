class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> hm = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            delete(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            //delete last entry for the same key
            delete(node);
        }
        if (hm.size() == capacity) {
            //delete LRU node
            delete(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
    }

    public void insert(Node node) {
        hm.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void delete(Node node) {
        hm.remove(node.key);
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}

class Node {

    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
