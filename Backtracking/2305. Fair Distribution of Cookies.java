class Solution {
    int ans = Integer.MAX_VALUE;
    int[] count;
    
    private void solve(int[] arr, int i, int k) {
        if(i==arr.length) {
            int f = 0;
            for(int p=0; p<k; p++) {
                f = Math.max(f, count[p]);
            } 
            ans = Math.min(f, ans);
            return;
        }
        
        
        for(int j=0; j<k; j++) {
            count[j] += arr[i];
            solve(arr, i+1, k);
            count[j] -= arr[i];
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        count = new int[k];
        solve(cookies, 0, k);
        return ans;
    }
}