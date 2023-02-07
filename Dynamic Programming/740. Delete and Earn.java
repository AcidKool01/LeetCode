class Solution {
//     int[] dp;
//     public int solve (int i, int[] nums, int k, int f) {
//         if(i<0) {
//             return 0;
//         } else if(nums[i]==k || nums[i]==f) {
//             return 0;
//         } else if(dp[i]!=-1) {
//             return dp[i];
//         }
        
//         return dp[i] = Math.max(nums[i] + solve(i-1, nums, nums[i] - 1, nums[i] + 1), solve(i-1, nums, k, f));
//     }
    
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return solve(n-1, nums, 0, 0);
//     }
    
        public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[]houses = new int[n]; //houses array will act as a house robber problem
        for(int num : nums){
            houses[num] += num;
        }
        return rob(houses);
    }
    
    public int rob(int[] nums) {
        int[]cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robHelper(nums, 0, cache);
    }
    
    private int robHelper(int[] nums, int idx, int[]cache){
        if(idx >= nums.length) return 0;
        if(cache[idx] != -1) return cache[idx];
        return cache[idx] = Math.max(robHelper(nums,idx+2, cache)+nums[idx], robHelper(nums,idx+1, cache));
    }
}