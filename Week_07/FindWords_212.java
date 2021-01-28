class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        List<String> res = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, res, trie, i, j, m, n);
            }
        }
        return res;
    }

    public void dfs(char[][] board, List<String> res, Trie trie, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        char c = board[i][j];
        if(c == '@') return;
        trie = trie.next[c - 'a'];
        if(trie == null) return;
        if(trie.word != null) {
            res.add(trie.word);
            trie.word = null;
        }
        board[i][j] = '@';
        dfs(board, res, trie, i + 1, j, m, n);
        dfs(board, res, trie, i - 1, j, m, n);
        dfs(board, res, trie, i, j + 1, m, n);
        dfs(board, res, trie, i, j - 1, m, n);
        board[i][j] = c;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String word = null;

        public void insert(String word) {
            Trie root = this;
            for(int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if(root.next[pos] == null) root.next[pos] = new Trie();
                root = root.next[pos];
            }
            root.word = word;
        }
    }
}