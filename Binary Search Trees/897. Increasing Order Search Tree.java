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
    private TreeNode result;
    private TreeNode prev;
    
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(result==null) {
            result = root;
        } else {
            prev.right = root;
        }
        prev = root;
        root.left = null;
        inorder(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return result;
    }
}