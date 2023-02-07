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
        List<List<Integer>> res = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        
        if(root==null) {
            return res;
        }
        
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> currentLevel = new LinkedList();
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                currentLevel.add(curr.val);
                
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                
                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }
            res.add(currentLevel);
        }   
        return res;
     }
}