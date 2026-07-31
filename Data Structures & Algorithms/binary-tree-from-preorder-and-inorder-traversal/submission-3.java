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
        if(preorder.length <= 0){
            return null;
        }

        Map<Integer, Integer> valueIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            valueIndex.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, valueIndex);
        
    }

    public TreeNode build(int[] preorder, int[] inorder,
                      int pStart, int pEnd,
                      int iStart, int iEnd,
                      Map<Integer, Integer> valueIndex) {
                        
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pStart]);

        int mid = valueIndex.get(preorder[pStart]);
        int leftSize = mid - iStart;

        node.left = build(preorder, inorder,
                pStart + 1, pStart + leftSize,
                iStart, mid - 1,
                valueIndex);

        node.right = build(preorder, inorder,
                pStart + leftSize + 1, pEnd,
                mid + 1, iEnd,
                valueIndex);

        return node;
}
}
