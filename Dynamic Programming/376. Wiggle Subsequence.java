class Solution {
  
    public int wiggleMaxLength(int[] a) {
        if(a.length < 2) return a.length;
        
        int i = 1; while(i < a.length && a[i] == a[i-1]) i++;
        if(i == a.length) return 1;
        
        int c = 2;
        boolean inc = a[i] > a[i-1];
        while(i < a.length) {
            if(inc) {
                while(i < a.length && a[i] >= a[i-1]) i++;
                if(i < a.length) c++; inc = false;
            }
            else {
                while(i < a.length && a[i] <= a[i-1]) i++;
                if(i < a.length) c++; inc = true;
            }
            
        }
        return c;
    }
}

// LIS SOLUTION : 

public int wiggleDPSolution(int[] a) {
    if(a.length < 2) return a.length;
    int inc[] = new int[a.length], dec[] = new int[a.length];
    Arrays.fill(inc,1);
    Arrays.fill(dec,1);        
    int ans = 1;
    for(int i=1;i<a.length;i++) {
        for(int j=0;j<i;j++) {
            if(a[j] < a[i]) inc[i] = Math.max(inc[i],1+dec[j]);
            if(a[j] > a[i]) dec[i] = Math.max(dec[i],1+inc[j]);
        }
        ans = Math.max(ans,Math.max(inc[i],dec[i]));
    }
    return ans;
}

