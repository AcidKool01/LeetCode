class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length, sum=0, revSum=0;
        int[] sumArray = new int[n];
        for (int i=0; i<n; i++) sum = sum + nums[i];
        for (int i=0; i<n; i++) {
            sumArray[i] = Math.abs(sum - nums[i]*(n-i)) + Math.abs(revSum - nums[i]*i);
            revSum+=nums[i]; sum-=nums[i];
        }
        return sumArray;
    }
}