class Trie {
    Trie[] next;
    boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
        end = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for(int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if((root.next[pos]) == null) {
                root = root.next[pos] = new Trie();
            } else {
                root = root.next[pos];
            }
        }
        root.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t = find(word);
        return t != null && t.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String word) {
        Trie root = this;
        for(int i = 0; i < word.length(); i++) {
            if((root = root.next[word.charAt(i) - 'a']) == null) break;
        }
        return root;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */