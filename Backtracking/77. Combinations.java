class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        combineUtil(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    
    private static void combineUtil(List<List<Integer>> res, List<Integer> temp, int start, int n, int k) {
        if(k==0) {
            res.add(new ArrayList<Integer> (temp));
            return;
        }
        
        for (int i=start; i<=n; i++) {
            temp.add(i);
            combineUtil(res, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
}