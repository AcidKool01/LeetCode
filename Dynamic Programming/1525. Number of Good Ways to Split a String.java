class Solution {
    public int numSplits(String s) {
        char[] arr = s.toCharArray();
        int res=0;
        
        int[] left = new int[26];
        int[] right = new int[26];
        int leftcount=0;   //will store number of unique characters in left string. 
        int rightcount=0;   //will store number of unique characters in right string.
		
		//store frequency of each character in right array.
        for(int i=0; i<arr.length;i++){
            right[arr[i]-'a']++;
            if(right[arr[i]-'a']==1) rightcount++;
        }
		
        for(int i=0;i<arr.length;i++){
            right[arr[i]-'a']--;
			left[arr[i]-'a']++;
            if(right[arr[i]-'a']==0) rightcount--; //decrement unique character on right side
            if(left[arr[i]-'a']==1) leftcount++; // increment unique character on left side.
            if(leftcount == rightcount) res++; // if unique characters are same on both side, its good split. 
        }
        
        return res;
    }
}