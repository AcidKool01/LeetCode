// using Catalan Number  ------>  O(N)

class Solution {
    public int numTrees(int n) {
        long ans = 1;
		int k = n;
        n = 2*n;
        
        for(int i = 0  ; i < k ;i++){
            ans *=  (n-i);
            ans /=  (i+1);
        }
        return (int)(ans/(k+1));
    }
}

// Using Dynamic Programming  ------->  O(N^2)

// public int numTrees(int n) {
//   int[] G = new int[n + 1];
//   G[0] = 1; G[1] = 1; // init
//   for (int i = 2; i <= n; ++i) {
//     for (int j = 1; j <= i; ++j) { // sum
//       G[i] += G[j - 1] * G[i - j];
//     }
//   }
//   return G[n];
// }