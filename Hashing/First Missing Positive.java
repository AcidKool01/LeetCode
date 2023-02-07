class Solution {
    
    public static int solve(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n)
                present[A[i]] = true;
        }

        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;
 
        return n + 1;
    }
    
    public int firstMissingPositive(int[] nums) {
        int res = solve(nums);
        return res;
    }
}

// Sexier Solution, Cyclic Sort

//	class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int i = 0;
//         while( i < nums.length){
//             if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
//                 swap(nums,i,nums[i] - 1);
//             }else{
//                 i++;
//             }
//         }
//         for(i = 0;i<nums.length;i++){
//             if(nums[i] != i + 1){
//                 return i + 1;
//             }
//         }
//         return nums.length + 1;
//     }
    
//     private void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }