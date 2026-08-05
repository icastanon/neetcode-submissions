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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode n, Integer floor, Integer ceiling){
        if(n == null){
            return true;
        }

        boolean leftValid = dfs(n.left, floor, n.val);
        boolean rightValid = dfs(n.right, n.val, ceiling);

        boolean currentValid = (floor == null || n.val > floor) && (ceiling == null || n.val < ceiling);

        

        return currentValid && leftValid && rightValid;
    }
}
