class Solution {
    
    private boolean solve(int[] arr, int idx) {
        if(idx<0 || idx>=arr.length || arr[idx]<0) return false;
        if(arr[idx]==0) return true;
        arr[idx] = arr[idx]*-1;
        return solve(arr, idx + arr[idx]) || solve(arr, idx - arr[idx]);
    }
    
    public boolean canReach(int[] arr, int start) {
        return solve(arr, start);
    }
}