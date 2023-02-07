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
    
//     private ArrayList<Integer> grandParent = new ArrayList<Integer>();
//     private List<List<Integer>> levelTraversal = new ArrayList();
    
//     private List<List<Integer>> levelOrder (TreeNode root) {
//         Queue<TreeNode> q = new LinkedList();
//         List<TreeNode> currLevel;
//         q.offer(root);
        
//         while(!q.empty) {
//             int size = q.size();
//             currLevel = new ArrayList();
            
//             for (int i=0; i<size; i++) {
//                 TreeNode currNode = q.poll();  
//                 currLevel.add(currNode);
                
//                 if(currNode.left != null) {
//                     q.offer(currNode.left);
//                 }
                
//                 if(currNode.right != null) {
//                     q.offer(currNode.right);
//                 }
                
//             }
            
//             levelTraversal.add(currLevel);
//         }
//     }
    
    private int ans;
    private void preorder (TreeNode root) {
        if(root==null) return;
        if(root.val%2==0) {
            if(root.left != null && root.left.left != null) ans+= root.left.left.val;
            if(root.left != null && root.left.right != null) ans+= root.left.right.val;
            if(root.right != null && root.right.left != null) ans+= root.right.left.val;
            if(root.right != null && root.right.right != null) ans+= root.right.right.val;
        } 
        
        preorder(root.left);
        preorder(root.right);
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        ans = 0;
        preorder(root);
        return ans;    
    }
}