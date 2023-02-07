/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode res = null;
    
    private void inorder (TreeNode root, TreeNode target) {
        if(root==null) return;
        inorder(root.left, target);
        if(root.val == target.val) {
            res = root;
            return;
        }
        inorder(root.right, target);
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(cloned, target);
        return res;
    }
}