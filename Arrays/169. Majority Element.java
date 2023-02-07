class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int startIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[startIndex] == nums[i]) cnt++;
            else cnt--;
            if (cnt == 0) {
                startIndex = i;
                cnt++;
            }
        }
        return nums[startIndex];
    }
}