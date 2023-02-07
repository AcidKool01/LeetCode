// Recursive Approach, pata nahi bc memo kyu nahi ho raha..2 ghanta nikal gaye aise hi..jabki recursive took just 10 mins :(

class Solution {
    
    public int solve(int prev, int n, int[] nums) {
        if(n==0) {
            return 0;
        }
        if(nums[n-1]<prev) {
            return Math.max(1+solve(nums[n-1], n-1, nums), solve(prev, n-1, nums));
        } else {
            return solve(prev, n-1, nums);
        }
        
    }
    
    public int lengthOfLIS(int[] nums) {
        return solve(Integer.MAX_VALUE, nums.length, nums);
    }
}

// Bottom - Up

public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i < n; i++){
            for(int j=0; j <= i-1; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

// Binary Search -- kya mazak hai yeh, kitna time nikla bas iss question mei :(

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            int index = Collections.binarySearch(list, num);

            if (index < 0) {
                index = (-index) - 1;
                if (index>=list.size()) {
                   list.add(num); 
                }
                else {
                    list.set(index, num);
                }
            }
        }
        // System.out.println(list);
        return list.size();
    }
}