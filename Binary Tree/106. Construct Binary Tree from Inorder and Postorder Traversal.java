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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0) 
            return null;
    
        int i = postorder.length-1, j = inorder.length-1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[i--]);
        stack.push(root);

        while(i >= 0){
            TreeNode curr = stack.peek();
            if(curr.val != inorder[j]){
                //as long as we have not reach the rightmost node we can safely follow right path and attach right child
                TreeNode right = new TreeNode(postorder[i]);
                curr.right = right;
                stack.push(right);
                i--;
            }else{
                //found the node from stack where we have not visited its left subtree
                while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                    curr = stack.pop();
                    j--;
                }

                TreeNode left = new TreeNode(postorder[i]);
                curr.left = left;
                stack.push(left);
                i--;
            }
        }

        return root;
    }
}