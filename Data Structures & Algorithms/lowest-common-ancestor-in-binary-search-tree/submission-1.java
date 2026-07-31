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

class Solution {
    List<TreeNode> lcas = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p.val);

        for(TreeNode n : lcas){
            System.out.println(n.val);
        }
        
        for(int i = lcas.size()-1; i>=0; i--){
            System.out.println(lcas.get(i).val);

            if(findNode(lcas.get(i), q.val) != null){
                System.out.println(q.val + " found for lcas " + lcas.get(i).val);
                return lcas.get(i);
            }
        }

        return null;
        
    }

    public TreeNode findNode(TreeNode root, int target){
        if(root == null){
            return null;
        }else if(root.val == target){
            lcas.add(root);
            return root;
        }else if(target > root.val){
            lcas.add(root);
            return findNode(root.right, target);
        }else{
            lcas.add(root);
            return findNode(root.left, target);
        }
    }
}
