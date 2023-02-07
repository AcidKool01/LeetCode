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
    
    TreeNode p = null, q = null;
    TreeNode prev = null;
    
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        
        inorder(root.left);
        
        if(prev!=null && p==null && prev.val>=root.val) {
            p=prev;
        }
        
        if(p!=null && prev.val>=root.val) {
            q=root;
        }
        
        prev = root;
        
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = p.val;
        p.val=q.val;
        q.val=temp;
    }
}