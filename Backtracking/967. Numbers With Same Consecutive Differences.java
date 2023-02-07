// brute force

class Solution {
    private List<Integer> list;
    
    private void backtrack(int n, int k, StringBuffer str) {
        if(str.length()==n) {
            for(int i=1; i<str.length(); i++) {
                if(Math.abs((int)str.charAt(i-1)-(int)str.charAt(i)) != k) {
                    str=null;
                    return;
                }
            }
            list.add(Integer.valueOf(str.toString()));
            str=null;
            return;
        }
        
        for(char c='0'; c<='9'; c++) {
            if(c=='0' && str.length()==0) continue;
            str.append(c);
            backtrack(n, k, str);
            str.deleteCharAt(str.length()-1);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<Integer>();
        backtrack(n, k, new StringBuffer());
        int[] res = new int[list.size()]; int i=0;
        for(Integer x: list) res[i++] = x;
        return res;
    }
}

// optimized

class Solution {
   public int[] numsSameConsecDiff(int N, int K) {
        List<String> tmp = new ArrayList<>();
        if(N == 1) tmp.add("0");
        helper(tmp, "", N, K);
        return tmp.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private void helper(List<String> tmp, String cur, int N, int K) {
		if(cur.length() == N) {
            tmp.add(cur);
            return;
        }
        if(cur.length() == 0) {
            for(int i = 1; i <= 9; i++) {
                helper(tmp, String.valueOf(i), N, K);
            }
        } else {
            int last = cur.charAt(cur.length() - 1) - '0';
            if(last + K <= 9) {
                helper(tmp, cur + String.valueOf(last + K), N, K);
            }
            if(last - K >= 0 && K!= 0) {
                helper(tmp, cur + String.valueOf(last - K), N, K);
            }    
        }
    }
}