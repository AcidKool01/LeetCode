class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    
    public void solve (int[] arr, int n, int target) {
        if(target==0) {
            res.add(new LinkedList<> (temp));
            return;
        }
            
        for (int i=n; i<arr.length; i++) {
            if(i>n && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            
            if(arr[i]<=target) {
                temp.add(arr[i]);
                solve(arr, i+1, target-arr[i]);
                temp.remove(temp.size()-1);
            } 
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList();
        temp = new LinkedList();
        Arrays.sort(candidates);
        
        solve(candidates, 0, target);
        return res;
    }
}