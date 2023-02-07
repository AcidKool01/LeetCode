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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) {
            return null;
        }
        
        int i=0, j=0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[i++]);
        TreeNode p=root;
        
        while(i<preorder.length) {
            if(p.val != inorder[j]) {
                p.left = new TreeNode(preorder[i]);
                st.push(p);
                p=p.left;
            } else {
                j++;
                while(!st.empty() && st.peek().val==inorder[j]) {
                    p = st.pop();
                    j++;
                }
                p.right = new TreeNode(preorder[i]);
                p=p.right;
            }   
            i++;
        }
        
        return root;
    }
}