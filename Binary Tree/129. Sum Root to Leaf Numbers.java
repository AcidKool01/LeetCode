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
    int ans = 0;
    private void solve(TreeNode root, int sum) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            sum = sum*10 + root.val;
            ans+=sum;
            sum = 0;
            return;
        }
        
        sum = sum*10 + root.val;
        solve(root.left, sum); solve(root.right, sum);
    }
    
    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return ans;
    }
}