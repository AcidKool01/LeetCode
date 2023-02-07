
// Binary Search

class Solution {
    public int findPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            int high = arr.length-1, low=i+1;
            while(low<=high) {
                int mid = low+(high-low)/2;
                if(arr[mid]-arr[i]==k) {
                    ans++;
                    break;
                } else if(arr[mid]-arr[i]>k) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } 
            
            while(i!=arr.length-1 && arr[i+1]==arr[i])
                i++;
        }
        
        return ans;
    }
}

// Hashmaps

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) {
                    ans++;
                }
                map.put(i, map.get(i) + 1);
            } else {
                if (map.containsKey(i - k)) {
                    ans++;
                }
                if (map.containsKey(i + k)) {
                    ans++;
                }
                map.put(i, 1);
            }
        }
        return ans;
    }
}