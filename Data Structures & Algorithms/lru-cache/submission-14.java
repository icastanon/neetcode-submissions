class LRUCache {
    Map<Integer, Node> cache;
    int capacity, size;
    Node head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        Node n = cache.get(key);
        if(n == null){
            return -1;
        }

        remove(n);
        insertAtTail(n);

        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = cache.get(key);
        if(n != null){
            remove(n);
            n.value = value;
            insertAtTail(n);
            cache.put(key, n);
        }else{
            Node newNode = new Node(key, value);
            
            insertAtTail(newNode);
            size++;
            
            if(size > capacity){
                int headKey = head.next.key;
                cache.remove(headKey);
                removeHead();
            }

            cache.put(key, newNode);
        }

    }

    private void insertAtTail(Node n){
        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;
    }

    private void removeHead(){
        Node currentHead = head.next;
        head.next = currentHead.next;
        head.next.prev = head;

        currentHead.next = null;
        currentHead.prev = null;
    }

    private static void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    class Node{
        int key, value;
        Node next, prev;

        public Node(){}

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
