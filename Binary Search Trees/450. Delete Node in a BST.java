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
    
    public TreeNode inorderSuccessor(TreeNode p) {
        TreeNode temp = p;
        while(temp.left!=null) {
            temp=temp.left;
        }
        return temp;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) {
            return null;
        }
        
        if(root.val<key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val>key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left==null && root.right==null) {
                root = null;
            } else if(root.left!=null && root.right==null) {
                root=root.left;
            } else if(root.left==null && root.right!=null) {
                root=root.right;
            } else {
                TreeNode succ = inorderSuccessor(root.right);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            }
        }
        
        return root;
    }
}