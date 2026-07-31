/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        Map<Integer, Node> copies = new HashMap<>();

        return dfs(node, copies);
    }

    public Node dfs(Node node, Map<Integer, Node> copies){
        Node copy;
        if(copies.get(node.val) != null){
            copy = copies.get(node.val);
        }else{
            //create copy of this node
            copy = new Node(node.val);

            copies.put(node.val, copy);
        
            List<Node> neighborsCopies = new ArrayList<>();

            for(Node neighbor : node.neighbors){
                Node neighborCopy = dfs(neighbor, copies);
                if(neighborCopy != null){
                    neighborsCopies.add(neighborCopy);
                }
            }

            copy.neighbors = neighborsCopies;
        }

        return copy;
    }
}