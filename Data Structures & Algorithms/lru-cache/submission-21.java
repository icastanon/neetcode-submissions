class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> map;

    Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null)
            return -1;

        n.prev.next = n.next;
        n.next.prev = n.prev;

        Node head = dummyHead.next;
        head.prev = n;
        n.next = head;
        n.prev = dummyHead;
        dummyHead.next = n;

        return n.val;
        
    }
    
    public void put(int key, int value) {
        int tailKey = -1;
        if(size == capacity && map.get(key) == null){
            Node tail = dummyTail.prev;
            // System.out.println("Removing tail with key " + tail.key);
            dummyTail.prev = tail.prev;
            tail.prev.next = dummyTail;
            tail.prev = null; 
            tail.next = null;
            tailKey = tail.key;
            size--;
        }

        map.remove(tailKey);

        Node node = map.get(key);
        if(node != null){
            map.remove(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }else{
            size++;
        }

        Node n = new Node(key, value);
        Node head = dummyHead.next;
        dummyHead.next = n;
        n.next = head;
        n.prev = dummyHead;
        head.prev = n;

        // System.out.println("Adding key " + n.key);

        map.put(key, n);

    }

    class Node{
        Node next;
        Node prev;
        int key;
        int val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
