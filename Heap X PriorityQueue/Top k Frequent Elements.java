class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr= new int[k]; 
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (Integer x: nums) {
            if(mp.containsKey(x)) {
                mp.put(x, mp.get(x)+1);
            } else {
                mp.put(x, 1);
            }
        }
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k, Comparator.comparing(Pair::getKey));
        
        int i=0;
        for (Map.Entry x: mp.entrySet()) {
            Pair<Integer, Integer> p = new Pair<Integer, Integer>((Integer)x.getValue(), (Integer)x.getKey());
            pq.add(p);
            if(i>=k) {
                // System.out.println(pq.peek().getKey() + " " + pq.peek().getValue());
                pq.poll();
            }
            i++;
        }
        
        i=0;
        
        while(!pq.isEmpty() && i<k) {
            arr[i++] = pq.peek().getValue();
            pq.poll();
        }
        
        return arr;
    }
}

// More Sexy Approach

class Solution {
//    public class Pair implements Comparable<Pair>
//     {
//         int num;
//         int count;
//        public Pair(int num,int count)
//        {
//             this.num=num;
//             this.count=count;
//        }
//        public int compareTo(Pair o)
//         {
//         return this.count - o.count;
//         }
         
//     }
    
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer> hm=new HashMap<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(hm.containsKey(nums[i]))
//             {
//                 int of=hm.get(nums[i]);
//                 int nf=of+1;
//                 hm.put(nums[i],nf);
//             }
//             else
//             {
//                 hm.put(nums[i],1);
//             }
//         }
//         PriorityQueue<Pair> pq=new PriorityQueue<>();
//         for(int key:hm.keySet())
//         {
//             Pair p=new Pair(key,hm.get(key));
//             if(pq.size()<k)
//             {
//                 pq.add(p);
//             }
//             else
//             {
//                 Pair curr=pq.peek();
//                 if(p.count>curr.count)
//                 {
//                     pq.remove(curr);
//                     pq.add(p);
                
//                 }
//             }
//         }
//        int[] res=new int[k];
//        for(int i=0;i<k;i++)
//        {
//            res[i]=pq.remove().num;
//        }
//         return res;
//     }
// }

// Sexiest Solution, lol

class Solution 
{
    public int[] topKFrequent(int[] nums, int k)
    {//T -> O(N log K)   S -> O(N)
        Map<Integer, Integer> map= new HashMap<>();//number -- frequency
        
        for(int i= 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);//counting the frequency of every element 
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>(k, (a, b)->{//k size Map //Sliding Window k size 
            return a.getValue() - b.getValue();//frequency based min heap//comparator customised sort 
        });
            
        for(Map.Entry<Integer, Integer> entry: map.entrySet())//dealing with each Entry in the Map 
        {
            if(pq.size() < k) //pushing the first k frequency element into the heap, it follows the property of top kth Elements 
                pq.offer(entry);
            else if(entry.getValue() > pq.peek().getValue())//entering is only allowed for higher frequency entry compared to the root of the Heap 
            {//sliding window size remains constant 
                pq.poll();//small peak are not entertained, because large frequency element is waiting 
                pq.offer(entry);//pushing the element with higher frequency and shifting the sliding window 
            }
        }
        
        int arr[]= new int[k];//resultant array containing the kth frequency element 
        
        for(int i= 0;i < k; i++)
             arr[i]= pq.poll().getKey();//polling the entry from the heap and adding to the array (desendingly sorded by frequency)
        
        return arr;//returning the resultant Array 
    }
}//please do Upvote, it helps a lot 