class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.remove(endWord)) return 0;
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add(beginWord);
        ends.add(endWord);
        int step = 1;
        while(!begins.isEmpty() && !ends.isEmpty()) {
            if(begins.size() > ends.size()) {
                Set<String> temp = begins;
                begins = ends;
                ends = temp;
            }
            Set<String> temp = new HashSet<>();
            for(String s : begins) {
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char c = ch[i];
                    for(char a = 'a'; a <= 'z'; a++) {
                        if(a == c) continue;
                        ch[i] = a;
                        String str = new String(ch);
                        if(ends.contains(str)) return step + 1;
                        if(words.contains(str)) temp.add(str);
                    }
                    ch[i] = c;
                }
            }
            words.removeAll(begins = temp);
            step++;
        }
        return 0;
    }
}