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
    private List<List<String>> res;
    
    private int height(TreeNode root) {
        if(root==null) return 0;
        int x = height(root.left);
        int y = height(root.right);
        
        return Math.max(x+1, y+1);
    }
    
    private void solve(TreeNode root, int h, int col) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<int[]> qIndex = new LinkedList<>();
        
        q.offer(root);
        qIndex.offer(new int[]{0, col-1});
        int row = -1;
        
        while(!q.isEmpty()) {
            row++;
            int n = q.size();
            for (int i=0; i<n; i++) {
                TreeNode curr = q.poll();
                int[] idx = qIndex.poll();
                
                int mid = idx[0] + (idx[1] - idx[0]) / 2;
                System.out.println(mid + " " + row);
                res.get(row).set(mid, String.valueOf(curr.val));
                
                if(curr.left != null) {
                    q.offer(curr.left);
                    qIndex.offer(new int[]{idx[0], mid-1});
                }
                
                if(curr.right != null) {
                    q.offer(curr.right);
                    qIndex.offer(new int[]{mid+1, idx[1]});
                }
            }
        }
    }
    
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int col = (int)Math.pow(2, h) - 1;
        // System.out.println(h + " " + col);
        
        res = new ArrayList();
        for (int i=0; i<h; i++) {
            List<String> temp = new ArrayList<>();
            for (int j=0; j<col; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        
        solve(root, h, col);
        return res;
    }
}