class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            if(i%2==1) i*=2;
            min=Math.min(min,i);
            q.add(i);
        }
        int diff=Integer.MAX_VALUE;
        while(q.peek()%2==0){
            int max=q.remove();
            diff=Math.min(diff,max-min);
            min=Math.min(min,max/2);
            q.add(max/2);
        }
        
        return Math.min(diff,q.peek()-min);
    }
}