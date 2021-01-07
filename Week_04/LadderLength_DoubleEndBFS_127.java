class Solution {
    /**
    * 双向BFS
    * 时间复杂度: O(N * C), N为wordList的长度，C为单词的长度
    * 空间复杂度：O(N * C), N为wordList的长度，C为单词的长度
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        Set<String> words = new HashSet<String>(wordList);
        if(!words.remove(beginWord) && !words.remove(endWord)) return 0;
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add(beginWord);
        ends.add(endWord);
        int level = 1;
        while(!begins.isEmpty() && !ends.isEmpty()) {
            if(begins.size() > ends.size()) {
                Set<String> temp = begins;
                begins = ends;
                ends = temp;
            }
            Set<String> set = new HashSet<>();
            for(String s : begins) {
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char oldChar = ch[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == oldChar) continue;
                        ch[i] = c;
                        String s1 = new String(ch);
                        if(ends.contains(s1)) return level + 1;
                        if(words.remove(s1)) set.add(s1);
                    }
                    ch[i] = oldChar;
                }
            }
            begins = set;
            level++;
        }
        return 0;
    }
}