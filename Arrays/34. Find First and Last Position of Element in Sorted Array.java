class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return new int[]{-1, -1};
        int[] res = new int[]{-1, -1};
        int low=0, high=n-1, mid=0;
        
        while(low<=high) {
            mid = (low+high)/2;
            if(nums[mid]==target) {
                res[0] = mid;
                high = mid-1;
            } else if(nums[mid]<target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        low=0; high=n-1; mid=0;
        
        while(low<=high) {
            mid = (low+high)/2;
            if(nums[mid]==target) {
                res[1] = mid;
                low = mid+1;
            } else if(nums[mid]<target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return res;
    }
}