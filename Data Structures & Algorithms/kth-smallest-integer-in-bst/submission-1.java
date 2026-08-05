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
    int index = 0, k, result;
    boolean found = false;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        
        dfs(root);

        return result;
        
    }

    public void dfs(TreeNode n){
        if(n == null || found){
            return;
        }

        dfs(n.left);

        index++;
        if(index == k){
            result = n.val;
        }

        if(!found)
            dfs(n.right);
    }
}
