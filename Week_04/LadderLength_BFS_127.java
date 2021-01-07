class Solution {
    /**
    * BFS
    * 时间复杂度：O(N * C), N为wordList的长度，C为单词长度
    * 空间复杂度：O(N * C), N为wordList的长度，C为单词长度
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        Set<String> words = new HashSet<>(wordList);
        if(!words.remove(beginWord) && !words.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            int width = queue.size();
            while(width-- > 0) {
                String s = queue.poll();
                if(s.equals(endWord)) return level;
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char oldChar = ch[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(oldChar == c) continue;
                        ch[i] = c;
                        String s1 = new String(ch);
                        if(words.remove(s1)) queue.offer(s1);
                    }
                    ch[i] = oldChar;
                }
            }
            level++;
        }
        return 0;
    }
}