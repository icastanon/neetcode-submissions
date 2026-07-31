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
    public int kthSmallest(TreeNode root, int k) {
        // List<List<Integer>> qq = bfs(root);

        // for(List<Integer> q : qq){
        //     for(Integer i : q){
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }

        // int i = 0;

        // while (i <= k){
        //     List<Integer> lowestLevel = qq.get(qq.size()-1);
        //     List<Integer> secondLowest = qq.get(qq.size()-2);

        //     while(!lowestLevel.isEmpty()){
        //         //remove left child
        //         Integer leftChild = lowestLevel.remove(0);
        //         if(leftChild != null){
        //             i++;
        //         }

        //         if(i == k){
        //             return leftChild;
        //         }

        //         //remove parent
        //         Integer parent = secondLowest.remove(0);
        //         if(parent != null){
        //             i++;
        //         }

        //         if(i == k){
        //             return parent;
        //         }

        //         //remove right child
        //         Integer rightChild = lowestLevel.remove(0);
        //         if(rightChild != null){
        //             i++;
        //         }

        //         if(i == k){
        //             return rightChild;
        //         }
        //     }

        //     qq.remove(qq.size()-1);
        // }

        List<Integer> ordered = new ArrayList<>();

        dfs(root, ordered);

        for(int i : ordered){
            System.out.println(i);
        }

        return ordered.get(k-1);



        
        
    }

    public List<List<Integer>> bfs(TreeNode root){
        //this method returns a queue of queues representing the levels
        List<List<Integer>> qq = new ArrayList<>();
        List<TreeNode> nodeQ = new ArrayList<>();

        nodeQ.add(root);

        while(!nodeQ.isEmpty()){
            List<Integer> levelQ = new ArrayList<>();

            int levelSize = nodeQ.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode n = nodeQ.remove(0);

                if(n != null){
                    nodeQ.add(n.left);
                }

                if(n != null){
                    nodeQ.add(n.right);
                }
                
                if(n != null){
                    levelQ.add(n.val);
                }else{
                    levelQ.add(null);
                }
            }

            qq.add(levelQ);
        }

        return qq;
    }

    public void dfs(TreeNode root, List<Integer> ordered){
        if(root != null){
            dfs(root.left, ordered);

            ordered.add(root.val);

            dfs(root.right, ordered);

            
        }
    }
}
