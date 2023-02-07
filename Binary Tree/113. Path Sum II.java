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
  List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> list=new ArrayList<>();
            helper(root,targetSum,0,list);
            return l;
        }
    
    public void helper(TreeNode root,int k,int sum,List<Integer> list) {
        if(root==null) {
            return;
        }
        
        list.add(root.val);
        sum+=root.val;
        
        if(root.left==null && root.right==null && sum==k) {
                l.add(new ArrayList<>(list));    
        }
        
        helper(root.left,k,sum,list);
        helper(root.right,k,sum,list);
        list.remove(list.size()-1);
    }
}