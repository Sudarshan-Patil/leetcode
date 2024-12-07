class Node {
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    Node(int key) {
        this.key = key;
    }
}
class LRUCache {
    HashMap<Integer, Node> hm = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }

        Node node = hm.get(key);
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        return;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            removeNode(node);
            addNode(node);
            node.value = value;
        } else {
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            addNode(newNode);
        }

        if (hm.size() > this.capacity) {
            Node node = tail.prev;
            hm.remove(node.key);
            removeTail();
        }

        return;
    }

    public void removeTail() {
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */