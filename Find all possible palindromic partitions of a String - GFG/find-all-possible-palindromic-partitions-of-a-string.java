//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends

class Solution {
    
    static ArrayList<ArrayList<String>> res;
    static ArrayList<String> temp;
    
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        solve(0, s);
        return res;
    }
    
    public static void solve (int i, String s) {
        if(i == s.length()) {
            res.add(new ArrayList<String>(temp));
        } else{
            for (int j=i; j<s.length(); j++) {
                if(isPalindrome(s, i, j)) {
                    temp.add(s.substring(i, j+1));
                    solve(j+1, s);
                    temp.remove(temp.size()-1);
                }
            }
        }    
    }
    
    public static boolean isPalindrome(String s, int low, int high){
       while(low < high)
          if(s.charAt(low++) != s.charAt(high--)) return false;
       return true;
    } 
}
