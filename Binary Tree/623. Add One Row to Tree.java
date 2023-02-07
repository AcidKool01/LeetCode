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
    
    private void solve(TreeNode root, int depth, int val) {
        if(root==null) return;
        
        if(depth-1==1) {
            TreeNode t1 = root.left;
            TreeNode t2 = root.right;
                
            root.left = new TreeNode(val, t1, null);
            root.right = new TreeNode(val, null, t2);
            return;
        } 
        
        solve(root.left, depth-1, val);
        solve(root.right, depth-1, val);

    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode ans = new TreeNode(val);  
            ans.left=root;
            return ans;
        }
        solve(root, depth, val);
        return root;
    }
}