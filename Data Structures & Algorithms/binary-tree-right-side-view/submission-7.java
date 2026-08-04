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
        List<List<Integer>> levels = getLevels(root);

        List<Integer> rightSide = new ArrayList<>();

        for(List<Integer> l : levels){
            Integer rightmost = l.get(l.size()-1);
            rightSide.add(rightmost);
        }

        return rightSide;
        
    }

    public List<List<Integer>> getLevels(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if(root != null){
            q.offer(root);

            while(!q.isEmpty()){
                int size = q.size();

                List<Integer> level = new ArrayList<>();

                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();

                    level.add(node.val);

                    if(node.left != null){
                        q.offer(node.left);
                    }

                    if(node.right != null){
                        q.offer(node.right);
                    }
                }

                levels.add(level);
            }
        }

        return levels;

    }
}
