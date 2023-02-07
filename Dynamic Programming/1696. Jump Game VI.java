// Not Optimized - DP O(n*k)

class Solution {
    int[] dp;
    private int solve(int[] nums, int i, int k, int n) {
        if(i>n-1) return 0;
        else if(i==n-1) return nums[n-1];
        else if(dp[i] != -1) return dp[i];
        
        int ans = Integer.MIN_VALUE;
        for (int j=i+1; j<=Math.min(n-1, i+k); j++) {
            ans = Math.max(ans, nums[i] + solve(nums, j, k, n));
        }
        
        return dp[i] = ans;
    }
    
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, k, n);
    }
}

// Optimized.. Sliding Window X PriorityQueue O(nlogn)

class Solution {
    public int maxResult(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        pq.add(new int[]{nums[nums.length-1], nums.length-1});
        
        for(int i = nums.length-2; i > 0; i--){
            
            while(pq.peek()[1] > i+k){
                pq.remove();
            }

            int nextMax = pq.peek()[0];
            pq.add(new int[]{nextMax+nums[i], i});
        }
        

        while(pq.peek()[1] > k){
            pq.remove();
        }

        return pq.peek()[0]+nums[0];
    }
}

