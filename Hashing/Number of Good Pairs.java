class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans=0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (Integer x: nums) {
            if(hash.containsKey(x)) {
                hash.put(x, hash.get(x)+1);
            } else {
                hash.put(x, 1);
            }
        }
        
        for (Map.Entry x: hash.entrySet()) {
            Integer temp = (Integer)x.getValue();
            ans+= (temp*(temp-1))/2;
        }
        
        return ans;
    }
}