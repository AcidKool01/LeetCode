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
    int res=0;
    
    public int height(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int x = height(root.left);
        int y = height(root.right);
        
        res = Math.max(res, x+y);
            
        return Math.max(x+1, y+1);    
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }
}