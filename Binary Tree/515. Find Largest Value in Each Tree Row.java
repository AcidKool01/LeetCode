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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        int temp=Integer.MIN_VALUE;
        
        if(root==null) {
            return list;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                temp = Math.max(temp, curr.val);
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }
            list.add(temp);
            temp=Integer.MIN_VALUE;
        }
        
        return list;
    }
}