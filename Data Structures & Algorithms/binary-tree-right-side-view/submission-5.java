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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
            
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            List<TreeNode> toOffer = new ArrayList<>();

            TreeNode polled = null;

            while(!q.isEmpty()){
                polled = q.poll();

                if(polled.left != null){
                    toOffer.add(polled.left);
                }

                if(polled.right != null){
                    toOffer.add(polled.right);
                }
            }

            result.add(polled.val);
            q.addAll(toOffer);

        }

        return result;
    }
}
