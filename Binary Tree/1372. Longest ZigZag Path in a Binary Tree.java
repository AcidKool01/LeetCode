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
    
    int ans = Integer.MIN_VALUE;
    private int solve(TreeNode root, int dir) {
        if(root==null) return 0;
        
        int x = 1, y =1;
        if(dir==1) {
            x += solve(root.right, 2);
            y += solve(root.left, 1);
        } else {
            x += solve(root.left, 1);
            y += solve(root.right, 2);
        }
        
        ans = Math.max(ans, Math.max(x, y));
        return x;
    }
    
    public int longestZigZag(TreeNode root) {
        // int flag = 0;
        if(root.left==null && root.right==null) return 0;
        solve(root, 1);
        solve(root, 2);
        
        return ans-1;
    }
}