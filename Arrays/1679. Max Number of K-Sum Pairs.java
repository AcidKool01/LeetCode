class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans=0;
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        
        while(i<j) {
            if(nums[i]+nums[j]==k) {
                ans++;
                i++; j--;
            } else if(nums[i]+nums[j]<k) {
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }
}

// One-Pass O(N)

public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(k-nums[i])) {
                res++;
                if(map.get(k-nums[i])==1) map.remove(k-nums[i]);
                else map.put(k-nums[i], map.get(k-nums[i])-1);
            }
            else map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return res;
}