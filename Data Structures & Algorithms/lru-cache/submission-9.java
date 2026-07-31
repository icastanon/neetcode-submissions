class LRUCache {
    Map<Integer, Node> cache;
    int capacity, size;
    Node head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = head;
    }
    
    public int get(int key) {
        System.out.println("getting key " + key);

        Node node = cache.get(key);

        if(node != null){
            //move it to the tail;
            if(node != tail){
                if(node == head){
                    head = head.next;
                    head.prev = null;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            

            return node.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        Node n = cache.get(key);
        if(n != null){
            n.value = value;
            get(key);
        }else{
            Node newNode = new Node(key, value);

            if(size == 0){
                head = newNode;
                tail = newNode;
                size++;
            }else if(size == capacity){
                System.out.println("removing key " + head.key);
                //remove head from map
                cache.remove(head.key);

                //remove head from linked list
                if(head == tail){
                    head = newNode;
                    tail = newNode;
                }else{
                    head = head.next;
                    head.prev = null;

                    //add new node to tail
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = tail.next;
                }
                
            }else{
                //add new node to tail without touching head
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;  
                size++;
            }

            System.out.println("putting key " + key);

            cache.put(key, newNode);
        }
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
