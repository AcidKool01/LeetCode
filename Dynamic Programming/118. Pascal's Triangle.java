class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> f = new LinkedList();
        f.add(1);
        res.add(f);
        List<Integer> row;
        
        for (int i=1; i<numRows; i++) {
            row = new LinkedList();
            // res.get(i).add(row);
            for (int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        
        return res;
    }
}