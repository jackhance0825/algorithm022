class Solution {
    /**
    * 双向BFS + DFS
    */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        if(!wordList.remove(beginWord) && !wordList.remove(endWord)) return ans;
        if(beginWord.equals(endWord)) {
            List<String> path = new LinkedList<>();
            path.add(beginWord);
            ans.add(path);    
            return ans;
        }
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        Set<String> words = new HashSet<String>(wordList);// 剩余的单词
        begins.add(beginWord);
        ends.add(endWord);
        words.remove(beginWord);
        words.remove(endWord);
        Map<String, Set<String>> neibours = new HashMap<>();// 邻接表
        boolean reach = false;
        boolean reverse = false;
        while(!begins.isEmpty() && !ends.isEmpty() && !reach) {
            if(begins.size() > ends.size()) {// 双向BFS，取宽度最小一方
                Set<String> temp = begins;
                begins = ends;
                ends = temp;
                reverse = !reverse;
            }
            Set<String> nexts = new HashSet<>();
            for(String s : begins) {
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char oldChar = ch[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == oldChar) continue;
                        ch[i] = c;
                        String s1 = new String(ch);
                        if(ends.contains(s1)) {
                            addNeibour(neibours, s, s1, reverse);
                            reach = true;
                        }
                        if(words.contains(s1)) {
                            addNeibour(neibours, s, s1, reverse);
                            nexts.add(s1);
                        }
                    }
                    ch[i] = oldChar;
                }
            }
            words.removeAll(nexts);
            begins = nexts;
        }
        if(reach) resolvePath(ans, neibours, beginWord, endWord);
        return ans;
    }

    // 邻接表
    private void addNeibour(Map<String, Set<String>> neibours, String a, String b, boolean reverse) {
        if(!reverse) {
            Set<String> an = neibours.get(a);
            if(an == null) neibours.put(a, an = new HashSet<>());
            an.add(b);
        } else {
            Set<String> bn = neibours.get(b);
            if(bn == null) neibours.put(b, bn = new HashSet<>());
            bn.add(a);
        }
    }

    // DFS 构造路径
    private void resolvePath(List<List<String>> ans, Map<String, Set<String>> neibours, String beginWord, String endWord) {
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        dfs(ans, path, neibours, endWord, beginWord);
    }

    private void dfs(List<List<String>> ans, List<String> path, Map<String, Set<String>> neibours, String endWord, String word) {
        if(word.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        Set<String> neibour = neibours.get(word);
        if(neibour == null) return;
        for(String nb : neibour) {
            path.add(nb);
            dfs(ans, path, neibours, endWord, nb);
            path.remove(path.size() - 1);
        }
    }
}