class Solution {
    
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if(nums.length==0) return 0;
        Set<Integer> s = new HashSet<Integer>();
        
        for (Integer x: nums) {
            s.add(x);
        }
        
        for (Integer x: nums) {
            int left = x-1;
            int right = x+1;
            
            while(s.remove(left)) left--;
            while(s.remove(right)) right++;
            
            ans = Math.max(ans, right-left-1);
            
            if(s.isEmpty())
                return ans;
        }
            
        return ans;
    }
}