class Solution {
    private Set<List<Integer>> res;
    private List<Integer> temp;
    
    private void backtrack(int[] nums, int i) {
        if(i==nums.length) return;
        
        for (int j=i; j<nums.length; j++) {
            if(temp.size()==0 || nums[j]>=temp.get(temp.size()-1)) {
                temp.add(nums[j]);
                if(temp.size()>1) res.add(new ArrayList<Integer>(temp));
                backtrack(nums, j+1);
                temp.remove(temp.size()-1);
            } 
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new HashSet<>();
        temp = new ArrayList<Integer>();
        backtrack(nums, 0);
        List<List<Integer>> list = new ArrayList<>();
        if(res.size()>0) list.addAll(res);
        return list;
    }
}