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
        return dfs(root);
    }

    public boolean dfs(TreeNode root){
        if(root != null){
            return isValid(root.left, root.val, -1001) && isValid(root.right, 1001, root.val);
        }

        return true;
    }

    public boolean isValid(TreeNode root, int ceiling, int floor){
        if(root != null){
            return root.val < ceiling && root.val > floor && isValid(root.left, root.val, floor) && isValid(root.right, ceiling, root.val);
        }
        return true;
    }
}
