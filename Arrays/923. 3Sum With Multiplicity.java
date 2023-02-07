class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length, mod = 1000000007;
        int countLeft = 0, countRight = 0, count = 0;
        Arrays.sort(arr);
        
        for (int i=0; i<n-2; i++) {
            int k = target - arr[i];
            int left = i+1, right = n-1;
            while(left < right) {
                if(arr[left] + arr[right]==k) {
                    countLeft = 1; countRight = 1;
                    while(left<right && arr[left]==arr[left+1])  { countLeft++; left++; } 
                    while(left<right && arr[right]==arr[right-1]) { countRight++; right--; } 
                    
                    if(left==right) count += (countLeft*(countLeft-1)/2);
                    else count += countLeft*countRight;
                    
                    count = count % mod;
                    
                    left++; right--;
                } else if (arr[left] + arr[right]<k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}