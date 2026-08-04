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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!q.isEmpty()){
            List<Integer> nodes = new ArrayList<>();
            List<TreeNode> toOffer = new ArrayList<>();

            while(!q.isEmpty()){
                TreeNode polled = q.poll();
                nodes.add(polled.val);

                if(polled.left != null){
                    toOffer.add(polled.left);
                }

                if(polled.right != null){
                    toOffer.add(polled.right);
                }
            }

            result.add(nodes);
            q.addAll(toOffer);
        }

        return result;
        
    }
}
