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

// MOST ANNOYING THING IN JAVA... NullPointerException :(

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null) {
            return res;
        }
        
        if(root.left==null && root.right==null) {
            List<Integer> f = new LinkedList<Integer>();
            f.add(root.val);
            res.add(f);
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        
        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> l = new LinkedList();
            for (int i=0; i<sz; i++) {
                TreeNode temp = q.remove();
                
                if(temp.left!=null) {
                    q.add(temp.left);
                }

                if(temp.right!=null) {
                    q.add(temp.right);
                }
                
                l.add(temp.val);
            }
            res.add(l);
        }
        
        Collections.reverse(res);
        return res;
    }
}