class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumHash = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                int pairSum = nums1[i] + nums2[j];
                sumHash.put(pairSum, sumHash.getOrDefault(pairSum, 0)+1);
            }
        }
        
        int res = 0;
        
        for(int i=0;i<nums3.length; i++) {
            for(int j=0; j<nums4.length; j++) {
                res += sumHash.getOrDefault(-1*(nums3[i]+nums4[j]), 0);
            }
        }
        
        return res;
    }
}