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
    int temp=0;
    
    public void inorder(TreeNode root, int k) {
        if(root==null) {
            return;
        }
        
        inorder(root.left, k);
        temp--;      
        if(temp==0) {
            res=root.val;
        }
        inorder(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        temp = k;
        inorder(root,k);
        return res;
    }
}