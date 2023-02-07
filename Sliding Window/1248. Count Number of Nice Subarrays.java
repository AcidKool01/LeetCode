class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, res = 0, count = 0, temp = 0;
        int i=0, j=0;
        while(j<n) {
            if(nums[j]%2==1) {
                count=0;
                temp++;
            }
            
            while(temp==k){
                if(i<n && nums[i++]%2==1) temp--;
                count++;
            }
            res+=count;
            j++;
        }
        
        return res;
    }
}