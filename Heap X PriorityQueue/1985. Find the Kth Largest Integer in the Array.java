// Solution #1

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<String>((str1, str2) ->{
            if(str1.length()==str2.length()) return str1.compareTo(str2);
            else return str1.length() - str2.length();
        });
        for (int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size()>k) pq.poll();
        }
        
        return pq.peek();
    }
}

// Solution #2

import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        if(nums==null || nums.length==0) return "";
        
        PriorityQueue<BigInteger> pq=new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            if(i<k) pq.add(new BigInteger(nums[i]));
            else{
                pq.add(new BigInteger(nums[i]));
                pq.poll();
            }
        }
        return pq.peek().toString();
    }
}