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
    private List<List<TreeNode>> level = new ArrayList();
    
    private void levelOrder (TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<TreeNode> list;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            list = new ArrayList();
            for (int i=0; i<size; i++) {
                TreeNode currNode = q.poll();
                list.add(currNode);
                
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            level.add(list);
        }
    }
    
    public int deepestLeavesSum(TreeNode root) {
        levelOrder(root);
        int ans = 0;
        for (TreeNode currNode: level.get(level.size()-1)) {
            ans += currNode.val;
        }
        
        return ans;
    }
}