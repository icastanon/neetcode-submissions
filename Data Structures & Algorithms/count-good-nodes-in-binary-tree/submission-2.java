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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return count;
        
    }

    public void dfs(TreeNode node, int largest){
        if(node == null)
            return;

        if(node.val >= largest){
            largest = node.val;
            count++;
        }
        
        dfs(node.left, largest);
        dfs(node.right, largest);

    }
}
