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
    public int maxd = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);

        return maxd;
        
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);

        int d = leftDepth + rightDepth - 2;

        maxd = Math.max(d, maxd);

        return leftDepth > rightDepth ? leftDepth : rightDepth;
        
    }
}
