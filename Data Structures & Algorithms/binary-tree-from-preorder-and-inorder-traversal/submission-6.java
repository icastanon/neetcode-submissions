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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        int rootVal = preorder[0];
        int leftSize = find(rootVal, inorder);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, leftSize+1), 
            Arrays.copyOfRange(inorder, 0, leftSize));
        
        root.right = buildTree(
            Arrays.copyOfRange(preorder, leftSize+1, preorder.length), 
            Arrays.copyOfRange(inorder, leftSize+1, inorder.length));

        return root;
    }

    public int find(int n, int[] list){
        for(int i = 0; i < list.length; i++){
            if(list[i] == n)
                return i;
        }

        return -1;
    }
}
