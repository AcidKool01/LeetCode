class Solution {
    public int maxProduct(int[] nums) {
        int mpp=nums[0]; 
        int mnp=nums[0]; 
        int omax=nums[0]; 
        
        
        for(int i=1;i<nums.length;i++){
            
            int val=nums[i];
            if(val<0){
                int temp1=mnp;
                int temp2=mpp;
              mpp=Math.max(val,temp1*val);
              mnp=Math.min(val,temp2*val);  
            }else{
               mpp=Math.max(val,val*mpp);
               mnp=Math.min(val,val*mnp); 
            }
            omax=Math.max(mpp,omax);
            
        }
        
        return omax;
    }
}

// O(1) Space ;-;

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        int dp2=nums[0], dp1=Math.max(nums[0],nums[1]),dp=dp1;
        
        for(int i = 2; i < n; i++){
            dp = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;

    }
}