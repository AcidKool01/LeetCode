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
    
    private int ans = 0;
    private int solve(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        
        int x = solve(root.left);
        int y = solve(root.right);
        
        int lh=0, rh=0;
        if(root.left!=null && root.left.val==root.val) {
            lh = 1 + x;
        }
        if(root.right!=null && root.right.val==root.val) {
            rh = 1 + y;
        }
        
        ans = Math.max(ans, lh+rh);
        return Math.max(lh, rh);
    }
    
    
    public int longestUnivaluePath(TreeNode root) {
        solve(root);
        return ans;
    }
}