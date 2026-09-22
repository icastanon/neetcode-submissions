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
        if(root == null)
            return new ArrayList<>();
            
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();

            while(!q.isEmpty()){
                TreeNode n = q.poll();

                if(n.left != null)
                    nextLevel.add(n.left);

                if(n.right != null)
                    nextLevel.add(n.right);

                level.add(n.val);
            }

            result.add(level);

            for(TreeNode n : nextLevel){
                q.offer(n);
            }
        }

        return result;
    }
}
