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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) {
            return res;
        }
        
        q.add(root);
        int depth=0;
        
        while(!q.isEmpty()) {
            List<Integer> list = new LinkedList();
            int size = q.size();
            depth++;
            for (int i=0; i<size; i++) {
                TreeNode tmp = q.poll();
                list.add(tmp.val);
                if(tmp.left!=null) {
                    q.add(tmp.left);
                }
                if(tmp.right!=null) {
                    q.add(tmp.right);
                }
            }
            if(depth%2==0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}

// DFS SOLUTION..

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    
    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}