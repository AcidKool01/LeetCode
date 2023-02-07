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
    
    private TreeNode solve(TreeNode root) {
        if(root==null) return null;
        
        TreeNode x = new TreeNode(root.val);
        x.left = solve(root.right);
        x.right = solve(root.left);
        
        return x;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        return solve(root);
    }
}