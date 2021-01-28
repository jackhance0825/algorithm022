class Solution {
    /**
    * Two-End BFS
    */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.remove(endWord)) return Collections.emptyList();
        words.remove(beginWord);
        Map<String, List<String>> adj = new HashMap<>();// 单词邻接情况
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add(beginWord);
        ends.add(endWord);
        boolean reach = false, swap = false;
        while(!begins.isEmpty() && !ends.isEmpty()) {
            if(begins.size() > ends.size()) {
                Set<String> temp = begins;
                begins = ends;
                ends = temp;
                swap = !swap;
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
                        if(ends.contains(str)) {
                            addAdj(adj, swap, s, str);// 添加邻接
                            reach = true;
                            continue;
                        }
                        if(!words.contains(str)) continue;
                        temp.add(str);// 添加下一层状态
                        addAdj(adj, swap, s, str);// 添加邻接
                    }
                    ch[i] = c;
                }
            }
            if(reach) break;
            words.removeAll(begins = temp);
        }
        return solvePath(adj, reach, beginWord, endWord);
    }

    private void addAdj(Map<String, List<String>> adj, boolean swap, String s0, String s1) {
        String key = swap ? s1 : s0;
        String val = swap ? s0 : s1;
        List<String> list = adj.get(key);
        if(list == null) adj.put(key, list = new LinkedList<>());
        list.add(val);
    }

    private List<List<String>> solvePath(Map<String, List<String>> adj, boolean reach, String beginWord, String endWord) {
        if(!reach) return Collections.emptyList();
        List<List<String>> res = new LinkedList<>();
        Deque<String> path = new LinkedList<>();
        path.offer(beginWord);
        dfs(res, adj, beginWord, endWord, path);
        return res;
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> adj, String a, String end, Deque<String> path) {
        if(a.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> nexts = adj.get(a);
        if(nexts == null) return;
        for(String s : nexts) {
            path.offer(s);
            dfs(res, adj, s, end, path);
            path.pollLast();
        }
    }
}