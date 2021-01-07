class Solution {
    /**
    * BFS，求最短路径
    */
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        boolean[] visited = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize-- > 0) {
                String s = queue.poll();
                if(s.equals(end)) return level;
                for(int i = 0; i < bank.length; i++) {
                    if(!visited[i] && changeMutation(s, bank[i]) == 1) {
                        queue.offer(bank[i]);
                        visited[i] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private int changeMutation(String s0, String s1) {
        int c = 0;
        for(int i = 0; i < s0.length(); i++) {
            if(s0.charAt(i) != s1.charAt(i)) c++;
        }
        return c;
    }
}