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
    TreeNode parentOfSmall = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        


        return findLca(root, p.val, q.val);
        
    }

    public TreeNode findLca(TreeNode root, int target, int target2){
        if(root == null){
            return null;
        }else if(root.val == target || root.val == target2){
            return root;
        }else if(target > root.val && target2 > root.val){
            return findLca(root.right, target, target2);
        }else if(target < root.val && target2 < root.val){
            return findLca(root.left, target, target2);
        }else{
            return root;
        }
    }
}
