/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        getPreorder(root, nodeList);

        String preOrderString = nodeList
            .stream()
            .map(
                (n) -> 
                {
                    return n == null ? "#" : String.valueOf(n.val);
                })
            .collect(Collectors.joining(","));

        System.out.println(preOrderString);

        return preOrderString;

        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");

        return recursive(strings);
        
    }

    private TreeNode recursive(String[] strings){
        if(index > strings.length || strings[index].equals("#")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strings[index]));
        index++;

        root.left = recursive(strings);
        root.right = recursive(strings);

        return root;

    }

    private void getPreorder(TreeNode root, List<TreeNode> nodeList){
        if(root == null){
            nodeList.add(null);
            return;
        }

        nodeList.add(root);
        getPreorder(root.left, nodeList);
        getPreorder(root.right, nodeList);

    }
}
