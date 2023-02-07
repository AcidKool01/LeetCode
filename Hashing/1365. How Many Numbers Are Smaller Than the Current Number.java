class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        int j=0, temp=0;
        for(int i=0; i<nums.length; i++) { count[nums[i]]++; }
        for(int i=0; i<100; i++) { j=count[i+1]; count[i+1] = count[i] + temp; temp = j; } count[0] = 0;
        for(int i=0; i<nums.length; i++) res[i] = count[nums[i]];
        return res;
    }
}