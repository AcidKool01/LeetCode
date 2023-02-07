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
    
    TreeMap<Integer, Integer> hash = new TreeMap<>(Collections.reverseOrder());
        
    public int solve(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int x = solve(root.left);
        int y = solve(root.right);
        int z = root.val;
                
        if(hash.containsKey(x+y+z)) {
            hash.put(x+y+z, hash.get(z+y+x)+1);
        } else {
            hash.put(x+y+z, 1);
        }
        
        return x+y+z;
    }     
        
    public int[] findFrequentTreeSum(TreeNode root) {
        solve(root);
        List<Integer> al = new ArrayList();
        
        int i=0;
        int temp=0;
        
        for (Map.Entry<Integer, Integer> entry: hash.entrySet()) {
            if(entry.getValue()>=temp) {             
                if(entry.getValue()>temp) {
                    al.clear();
                    temp = entry.getValue();
                }
                al.add(entry.getKey());
            }
        }
        
        int[] arr = al.stream().mapToInt(a -> a).toArray();
        
        return arr;
        
    }
}