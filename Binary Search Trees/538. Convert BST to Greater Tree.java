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

// Not effiecient, vro ;-;

class Solution {
    int sum=0;
    public int findSum (TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        return findSum(root.left) + findSum(root.right) + root.val;
    }
    
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        
        inorder(root.left);
        int temp = sum-root.val;
        root.val = sum;
        sum = temp;
        inorder(root.right);
    }
    
    public TreeNode convertBST(TreeNode root) {
        TreeNode p = root;
        sum = findSum(p);
        // System.out.println(sum);
        p = root;
        inorder(p);
        
        return root;
    }
}

// Reverse Inorder, lol ;-;

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
    int sum = 0;
    
    public void solve(TreeNode root) {
        if (root == null) return;
        solve(root.right);
        root.val += sum;
        sum = root.val;
        solve(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }
    
}