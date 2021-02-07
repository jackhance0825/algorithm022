class LRUCache {
    Map<Integer, Node> map;
    final int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(this.capacity = capacity, 1f);
        head = tail = new Node();
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n != null && n != head.next) {
            removeNode(n);
            add2Head(n);
        }
        return n == null ? -1 : n.value;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null) {
            n.value = value;
            if(n != head.next) {
                removeNode(n);
                add2Head(n);
            }
        } else {
            if(map.size() == capacity) {
                map.remove(tail.key);// 切记先移除map，因为remove方法会改变tail值
                removeNode(tail);
            }
            map.put(key, n = new Node(key, value));
            add2Head(n);
        }
    }

    private void removeNode(Node n) {
        if(n == null || n == head) return;
        if(n == tail) {
            tail = n.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    private void add2Head(Node n) {
        if(n == null || n == head) return;
        if(head == tail) {
            head.next = n;
            n.prev = head;
            tail = n;
            n.next = null;
        } else {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(){}
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */