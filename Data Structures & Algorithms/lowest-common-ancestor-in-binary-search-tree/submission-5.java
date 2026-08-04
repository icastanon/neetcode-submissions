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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        return dfs(root, min, max);
    }

    public TreeNode dfs(TreeNode n, int min, int max){
        if(n.val >= min && n.val <= max){
            return n;
        }else if(n.val >= min && n.val >= max){
            return dfs(n.left, min, max);
        }else{
            return dfs(n.right, min, max);
        }
    }
}
