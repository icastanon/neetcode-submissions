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
    public boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);

        return balanced;
        
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if( (leftHeight > rightHeight && (leftHeight-rightHeight) > 1 ) ||
            (rightHeight > leftHeight && (rightHeight-leftHeight) > 1 ) ){
                balanced = false;
            }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
