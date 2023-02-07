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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        if(root==null) {
            return res;
        }
        
        // if(root.next==null)
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().val);
            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.right!=null) {
                    q.add(curr.right);
                }
                
                if(curr.left!=null) {
                    q.add(curr.left);
                }
            }
        }
        return res;
    }
}


// Recursive Approach

    int depth = 0;
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return ans;
        
        depth++;
        
        if (ans.size() < depth)
            ans.add(root.val);
        
        ans = rightSideView(root.right);
        ans = rightSideView(root.left);
        
        depth--;
        
        return ans;
    }