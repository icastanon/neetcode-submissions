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
        Map<Node, Node> map = new HashMap<>();

        Node n = head;
        while(n != null){
            Node copy = new Node(n.val);
            map.put(n, copy);
            n = n.next;
        }

        n = head;
        Node dummy = new Node(0);
        dummy.next = map.get(head);
        while(n != null){
            Node copy = map.get(n);
            copy.next = map.get(n.next);
            copy.random = map.get(n.random);
            n = n.next;
        }


        return dummy.next;
    }
}
