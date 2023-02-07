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
    
    private boolean solve(TreeNode root) {
        if(root==null) return false;
        
        boolean left = solve(root.left);
        boolean right = solve(root.right);
        
        if(!left) {
            root.left = null;
        }
        
        if(!right) {
            root.right = null;
        }
        
        return root.val == 1 || left || right;
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        solve(root);
        if(root.left==null && root.right==null && root.val==0) return null;
        return root;
    }
}

// 2

class Solution {
    public TreeNode pruneTree(TreeNode root) {
		if (root == null) 
		{
			return null;
		}
		if (!containsOne(root))
		{
			return null ;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		return root;    
    }

    private boolean containsOne(TreeNode root) 
    {
        if (root == null) 
        {
            return false;
        }
        if (root.val == 1) 
        {
            return true ;
        }
        return containsOne(root.left) || containsOne(root.right); 
    }
}