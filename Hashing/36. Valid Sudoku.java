class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean flag =true;
        for(char[] row: board) {
            Set<Character> set = new HashSet<>();
            for(char c: row) {
                // System.out.print(c + " ");
                if(set.contains(c)) return false;
                if(c != '.') set.add(c);
            }
            // System.out.println();
        }
        
        for(int i=0; i<n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j=0; j<n; j++) {
                char c = board[j][i];
                if(set.contains(c)) return false;
                if(c != '.') set.add(c);
            }
        }
        
        for(int k=0; k<9; k+=3) {
            for (int l=0; l<9; l+=3) {
                Set<Character> set = new HashSet<>();
                for(int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        char c = board[i+k][j+l];
                        if(set.contains(c)) return false;
                        if(c != '.') set.add(c);
                    }
                }    
            }
            
        }
        
        return true;
    }
}