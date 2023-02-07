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
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    private int solve(TreeNode root) {
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        
        int val = 0;
        if(root.left != null) {
            val = val + solve(root.left.right) + solve(root.left.left);
        }
        
        if(root.right != null) {
            val = val + solve(root.right.left) + solve(root.right.right);
        }
        
        val = Math.max(root.val + val, solve(root.left) + solve(root.right));
        map.put(root, val);
        return val;
    }
    
    public int rob(TreeNode root) {
        return solve(root);
    }
}