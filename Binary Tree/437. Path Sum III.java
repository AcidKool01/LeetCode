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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}



// huehuehue

public int pathSum(TreeNode root, int targetSum) {
        int[] ans = new int[1];
        Map<Integer,Integer> map = new HashMap<>(); // to store all prefix sum
        map.put(0,1); // to handle case where currSum == target
        traverse(root,0,map,ans,targetSum);
        return ans[0];
 
    }
    
    public void traverse(TreeNode root, int currSum, Map<Integer,Integer> map, int[] ans, int targetSum){
        if(root == null)
            return;
        currSum+=root.val;
        
        if(map.containsKey(currSum - targetSum) && map.get(currSum - targetSum) > 0)
            ans[0]+=map.get(currSum - targetSum);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        traverse(root.left, currSum, map, ans,targetSum);
        traverse(root.right, currSum, map, ans, targetSum);
        map.put(currSum,map.getOrDefault(currSum,0)-1); // backtrack

    }