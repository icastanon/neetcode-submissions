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
    Integer max = -1001;
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
        
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int currentVal = root.val;

        int leftMaxSum = dfs(root.left);
        int rightMaxSum = dfs(root.right);

        if(leftMaxSum + currentVal < currentVal){
            leftMaxSum = 0;
        }

        if(rightMaxSum + currentVal < currentVal){
            rightMaxSum = 0;
        }

        int sumOfLegs = rightMaxSum + leftMaxSum;
        

        int total = currentVal + sumOfLegs;

        max = Math.max(max, total);

        return Math.max(rightMaxSum, leftMaxSum) + currentVal;

    }
}
