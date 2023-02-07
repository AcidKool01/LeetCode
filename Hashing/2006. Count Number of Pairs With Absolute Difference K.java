class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(Integer x: nums) map.put(x, map.getOrDefault(x, 0)+1);
        for(Integer x: nums) { count=count+map.getOrDefault(x+k, 0); }
        return count;
    }
}