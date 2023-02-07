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
    
    public boolean isValidBST(TreeNode root) {
        return helper(root,null, null);
    }

    public boolean helper(TreeNode root, Integer max, Integer min){ 
        if(root == null) return true;
        if(root.left != null){
            if(root.left.val >= root.val || (min != null && (root.left.val <= min) )|| !helper(root.left,root.val,min))                     return false;
        }

        if(root.right != null){
            if(root.right.val <= root.val || (max != null && (root.right.val >= max)) || !helper(root.right,max,root.val))                  return false;
        }

        return true;
    }
}