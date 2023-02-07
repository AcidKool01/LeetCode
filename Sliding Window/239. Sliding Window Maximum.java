class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int i=0, j=0;
        int n = nums.length;
        int maxValue=0;
        int p=0;
        
//         while(j<n) {
//             maxValue = Math.max(maxValue, nums[j]);
//             if(k>j-i+1) {
//                 j++;
//             } else if(k==j-i+1) {
//                 res[p++] = maxValue;
//                 j++;
//             } else {
//                 if(maxValue==nums[i])
//                     maxValue = nums[i+1];
//                 i++;
//             }
            
//         }
        
//         return res;
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (;i<n; i++) {
            while(!q.isEmpty() && nums[q.getLast()]<=nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if(q.getFirst() == i-k) {
                q.removeFirst();
            }
            
            if(i>=k-1) {
                res[p++] = nums[q.peek()];
            }
        }
        
        return res;
    }
}
