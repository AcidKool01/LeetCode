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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root==null) {
            return 0;
        }
        
        q.add(root);
        TreeNode p = root;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                p = q.poll();
                if(p.right!=null) {
                    q.add(p.right);
                }
                if(p.left!=null) {
                    q.add(p.left);
                }                
            }
        }
        
        return p.val;
    }
}