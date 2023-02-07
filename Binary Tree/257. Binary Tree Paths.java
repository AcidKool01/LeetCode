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
    
    List<String> ans;
    private boolean solve(TreeNode root, String temp) {
        if(root==null) return false;
        else if(root.left==null && root.right==null) {
            String s=String.valueOf(root.val);
            temp = temp + s;
            ans.add(temp);
            temp="";
            return true;
        }
        
        temp = temp + String.valueOf(root.val) + "->";
        solve(root.left, temp); solve(root.right, temp);
        return true;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList();
        solve(root, "");
        return ans;
    }
}