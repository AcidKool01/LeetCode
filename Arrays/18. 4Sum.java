//eh...solution but faster lmao xD

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        int n = nums.length;
        
        for(int i=0; i<n-3; i++) {
            
            if(i>0 && nums[i-1]==nums[i]) continue;
            
            for (int j = i+1; j<n-2; j++) {
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                int low = j+1;
                int high = n-1;
                int sum = target - (nums[i] + nums[j]);
                while(low<high) {
                    if(nums[low] + nums[high] == sum) {
                        if(!res.contains(Arrays.asList(nums[i], nums[j], nums[low], nums[high])))     // sed ;-;
                            res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        if(low<high && nums[low]==nums[low+1]) low++; 
                        if(low<high && nums[high]==nums[high-1]) high--; 
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
            

        }
        return res;
    } 
}

// Sexier but for some reason slower than above ;-; ===> leetcode

// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
        
//         Arrays.sort(nums);
//         List<List<Integer>> res = new LinkedList();
//         int n = nums.length;
        
//         for(int i=0; i<n-3; i++) {
 
//             if(i>0 && nums[i-1]==nums[i]) continue;
            
//             for (int j = i+1; j<n-2; j++) {
//                 if(j>i+1 && nums[j-1]==nums[j]) continue;
//                 int low = j+1;
//                 int high = n-1;
//                 // int sum = target - (nums[i] + nums[j]);
//                 while(low<high) {
//                     int sum = nums[low] + nums[high] + nums[i] + nums[j];
//                     if(sum == target) {
//                         res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
//                         low++;
//                         high--;
//                         while(low<high && nums[low]==nums[low-1]) low++; 
//                         while(low<high && nums[high]==nums[high+1]) high--; 
//                     } else if(sum > target) {
//                         high--;
//                     } else {
//                         low++;
//                     }
//                 }
//             }
            

//         }
//         return res;
//     } 
// }

