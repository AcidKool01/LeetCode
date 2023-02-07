class Solution {    
    public int numSubseq(int[] nums, int t) {
        Arrays.sort(nums);
        
        int n = nums.length, l = 0, r = n - 1, mod = (int)1e9 + 7;
        long res = 0, pow[] = new long[n + 1];
        pow[0] = 1;
        
        for (int i = 1 ; i <= n ; ++i) pow[i] = pow[i - 1] * 2 % mod;
        
        while(l <= r && nums[r] + nums[l] > t) r--; // find the first right pointer;
        
        while(l <= r){
            while (l <= r && nums[r] + nums[l] <= t) l++;
            l--;
            if (r == l) res = (res + pow[l + 1] - 1) % mod;   // corner casem 
            else res = (res + pow[r - l - 1] * (pow[l + 1] - 1)) % mod;  //sigma(f(l))
            r--;
        
        }
        return (int) res;
    }
}