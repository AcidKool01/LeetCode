class Solution {
    public int subarraySum(int[] nums, int k) {
        int temp=0;
        int count=0;
        HashMap<Integer, Integer> hash  = new HashMap<Integer, Integer>();
        for (Integer x: nums) {
            temp+=x;
            
            if(temp==k) {
                count++;
            }
            
            if(hash.containsKey(temp-k)) {
                count+=hash.get(temp-k);
            }
            
            if(hash.containsKey(temp)) {
                hash.put(temp, hash.get(temp)+1);
            } else {
                hash.put(temp, 1);
            }
        }
        
        return count;
    }
}