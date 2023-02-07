class Solution {
    private Map<Integer, ArrayList<Integer>> dp;
    private List<Integer> solve(int[] nums, int i) {
        if(dp.containsKey(i)) return dp.get(i);
        ArrayList<Integer> maxLen = new ArrayList<>();
        int div = i==0 ? 1 : nums[i-1];

        for(int j=i; j<nums.length; j++) {
            if(nums[j]%div==0) {
                ArrayList<Integer> list = new ArrayList<Integer>(solve(nums, j+1));
                list.add(nums[j]);
                if(list.size() > maxLen.size()) {
                    maxLen = list;
                }
            }
        }
        
        dp.put(i, maxLen);
        return maxLen;
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        dp = new HashMap<Integer, ArrayList<Integer>>();
        Arrays.sort(nums);
        return solve(nums, 0);
    }
}