class Solution {
    char[] mutas = new char[]{'A', 'C', 'G', 'T'};
    /**
    * Two-End BFS
    */
    public int minMutation(String start, String end, String[] bank) {
        if(start == null || end == null) return start == null && end == null ? 0 : -1;
        Set<String> banks = new HashSet<>();
        for(String b : bank) banks.add(b);
        if(!banks.remove(end)) return -1;
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add(start);
        ends.add(end);
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
                    for(char m : mutas) {
                        if(m == c) continue;
                        ch[i] = m;
                        String str = new String(ch);
                        if(ends.contains(str)) return step;
                        if(!banks.contains(str)) continue;
                        temp.add(str);
                    }
                    ch[i] = c;
                }
            }
            banks.removeAll(begins = temp);
            step++;
        }
        return -1;
    }

    
    /**
    * BFS
    */
    public int minMutation1(String start, String end, String[] bank) {
        if(start == null || end == null) return start == null && end == null ? 0 : -1;
        Set<String> banks = new HashSet<>();
        for(String b : bank) banks.add(b);
        if(!banks.contains(end)) return -1;
        Queue<String> begins = new LinkedList<>();
        begins.offer(start);
        int step = 0;
        while(!begins.isEmpty()) {
            int size = begins.size();
            while(size-- > 0) {
                String s = begins.poll();
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char c = ch[i];
                    for(char m : mutas) {
                        if(m == c) continue;
                        ch[i] = m;
                        String str = new String(ch);
                        if(!banks.remove(str)) continue;
                        if(str.equals(end)) return step + 1;
                        begins.offer(str);
                    }
                    ch[i] = c;
                }
            }
            step++;
        }
        return -1;
    }
}