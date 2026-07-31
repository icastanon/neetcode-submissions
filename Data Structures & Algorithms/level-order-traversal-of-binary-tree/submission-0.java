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
        List<List<Integer>> result = new ArrayList<>();

        traverse(root, 0, result);
        
        return result;
        
    }

    public void traverse(TreeNode root, int index, List<List<Integer>> list){
        if(root != null){
            try{
                List<Integer> level = list.get(index);
                level.add(root.val);
            }catch(IndexOutOfBoundsException e){
                List<Integer> level = new ArrayList<>();
                level.add(root.val);
                list.add(level);
            }

            //traverse left side
            traverse(root.left, index+1, list);

            //traverse right side
            traverse(root.right, index+1, list);
        }

    }
}
