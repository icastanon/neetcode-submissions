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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return result;
        
    }

    public int dfs(TreeNode n){
        if(n == null){
            return 0;
        }

        int left = dfs(n.left);
        int right = dfs(n.right);

        if(Math.abs(left - right) > 1){
            result = false;
        }

        return 1 + Math.max(left, right);
    }
}
