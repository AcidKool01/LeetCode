class Solution {
    public int missingNumber(int[] nums) {
        int s = 0;
        int flag=0;
        for (int i=0; i<nums.length; i++) {
            s+=nums[i];
            if(nums[i]==0) {
                flag=1;
            }
        }
        
        if(flag==0) {
            return 0;
        }
        
        int k = (nums.length)*(nums.length+1)/2;
        
        if(k==s) {
            return nums.length;
        } else {
            return k-s;
        }
    }
}