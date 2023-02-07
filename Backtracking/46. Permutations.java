class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        perm(result,nums,0,nums.length-1);
        return result;
    }
    
    public static void perm(List<List<Integer>> result, int[] nums, int start, int end){
	if(start==end){
            Integer[] ele = new Integer[nums.length];
            for(int i=0; i<nums.length; i++){
                ele[i] = nums[i];
	    }
	    result.add(Arrays.asList(ele));
	    } else {
            	for(int i=start; i<=end; i++){
                    int temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;

                    perm(result, nums,start+1,end);

                    temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;
              	}
          }
   }
}