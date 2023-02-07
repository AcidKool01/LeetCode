class Solution {
    private int ans = 0;
    private void solve(int[] arr, int i) {
        if(i==arr.length) {
            ans++;
            return;
        }
        
        for (int idx=1; idx<arr.length; idx++) {
            if(arr[idx]==0 && (i%idx==0 || idx%i==0)) {
                arr[idx] = 1;
                solve(arr, i+1);
                arr[idx] = 0;
            }
            else continue;
        }
    }
    
    public int countArrangement(int n) {
        if(n==1) return 1;
        int[] arr = new int[n+1];
        
        solve(arr, 1);
        return ans;
    }
}