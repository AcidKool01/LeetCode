class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    
    public void solve (int[] arr, int n, int target) {
        if(n==arr.length) {
            if(target==0) {
                res.add(new LinkedList<> (temp));
            }
            return;
        } 
        
        if(arr[n]<=target) {
            temp.add(arr[n]);
            solve(arr, n, target-arr[n]);
            temp.remove(temp.size()-1);
        }
        
        solve(arr, n+1, target);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        temp = new LinkedList();
        solve(candidates, 0, target);
        return res;
    }
}