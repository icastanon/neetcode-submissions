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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int maxLeftSum = dfs(root.left);
        int maxRightSum = dfs(root.right);

        maxLeftSum = maxLeftSum < 0 ? 0 : maxLeftSum;
        maxRightSum = maxRightSum < 0 ? 0 : maxRightSum;

        int currentPathSum = maxLeftSum + maxRightSum + root.val;

        max = Math.max(max, currentPathSum);

        // System.out.println("Current max while visiting node " + root.val + ": " + max);

        return Math.max(maxLeftSum, maxRightSum) + root.val;
    }
}
