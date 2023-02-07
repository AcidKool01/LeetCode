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
    List<TreeNode> res;
    Map<String, Integer> mp = new HashMap<String, Integer>();
    private String solve(TreeNode root) {
        if(root==null) return "#";
        
        String curr = root.val + "," + solve(root.left) + "," + solve(root.right);
        mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        
        if(mp.get(curr)==2) res.add(root);  
        return curr;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<TreeNode>();
        solve(root);
        return res;
    }
}