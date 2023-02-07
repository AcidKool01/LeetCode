// Not Optimised. Without Tries

class Solution {
    private List<String> res;
    private Set<String> set;
    
    private void solve(char[][] board, int i, int j, String word, int x, String curr) {
        if(x == word.length()) {
            if(curr.equals(word)) set.add(word);
            curr="";
            return;
        }
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if(board[i][j] != word.charAt(x)) return;
        if(board[i][j] == word.charAt(x)) curr = curr + word.charAt(x);
        
        board[i][j] = '*';
        solve(board, i+1, j, word, x+1, curr);
        solve(board, i, j+1, word, x+1, curr);
        solve(board, i-1, j, word, x+1, curr);
        solve(board, i, j-1, word, x+1, curr);
        board[i][j] = word.charAt(x);
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<String>();
        set = new HashSet<String>();
        int n = board.length, m = board[0].length;
        for (String word: words) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    solve(board, i, j, word, 0, "");
                }
            }
        }
        
        for(String x: set) {
            res.add(x);
        }
        
        return res;
    }
}


// Optimised. With Trie :)

class Solution {
    private List<String> res;
    private Set<String> set;
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    private void solve(char[][] board, int i, int j, TrieNode x, String curr) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        
        Character c = board[i][j];
        if (c == '#') return;
        if (x.next[c-97] == null) return;
        x = x.next[c-97];
        if (x.word != null) {   // found one
            res.add(x.word);
            x.word = null;     // de-duplicate
        }
        
        board[i][j] = '#';
        solve(board, i+1, j, x, curr);
        solve(board, i, j+1, x, curr);
        solve(board, i-1, j, x, curr);
        solve(board, i, j-1, x, curr);
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        // set = new HashSet<String>();
        int n = board.length, m = board[0].length;
        res = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                solve(board, i, j, root, "");
            }
        }

        return res;
    }
}