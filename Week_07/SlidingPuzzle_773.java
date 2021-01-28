class Solution {
    /**
    * A*
    */
    public int slidingPuzzle(int[][] board) {
        int index0 = 0;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                s.append((char)('0' + board[i][j]));
                if(board[i][j] == 0) index0 = i * 3 + j;
            }
        }
        String start = s.toString();
        if(start.equals("123450")) return 0;
        Map<String, Node> visited = new HashMap<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.heuristic - b.heuristic);
        Node sn = new Node(start.toCharArray(), 0, index0);
        queue.offer(sn);
        visited.put(sn.board, sn);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            char[] cur = n.board.toCharArray();
            for(int m : move[n.index0]) {
                char c = cur[m];// m位置原字符
                cur[m] = '0';
                cur[n.index0] = c;
                String str = new String(cur);
                if(str.equals("123450")) return n.step + 1;
                Node oldNode = visited.get(str);
                if(oldNode == null || oldNode.step > n.step + 1) {
                    Node newNode = new Node(cur, n.step + 1, m);
                    queue.offer(newNode);
                    visited.put(newNode.board, newNode);
                }
                // 回溯字符位置
                cur[m] = c;
                cur[n.index0] = '0';
            }
        }
        return -1;
    }

    /**
    * BFS
    */
    public int slidingPuzzle1(int[][] board) {
        int index0 = 0;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                s.append((char)('0' + board[i][j]));
                if(board[i][j] == 0) index0 = i * 3 + j;
            }
        }
        String start = s.toString();
        if(start.equals("123450")) return 0;
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0, index0));
        visited.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node n = queue.poll();
                char[] cur = n.board.toCharArray();
                for(int m : move[n.index0]) {
                    char c = cur[m];// m位置原字符
                    cur[m] = '0';
                    cur[n.index0] = c;
                    String str = new String(cur);
                    if(str.equals("123450")) return n.step + 1;
                    if(!visited.contains(str)) {
                        queue.offer(new Node(str, n.step + 1, m));
                        visited.add(str);
                    }
                    // 回溯字符位置
                    cur[m] = c;
                    cur[n.index0] = '0';
                }
            }
        }
        return -1;
    }
    
    int[][] move = new int[][]{
        {1, 3},
        {0, 2, 4},
        {1, 5},
        {0, 4},
        {1, 3, 5},
        {2, 4}
    };

    class Node {
        String board;
        int step;
        int index0;
        int heuristic;
        Node(String board, int step, int index0) {
            this.board = board;
            this.step = step;
            this.index0 = index0;
        }

        Node(char[] board, int step, int index0) {
            this(new String(board), step, index0);
            this.heuristic = step;// 当前代价
            for(int i = 0; i < board.length; i++) {
                int num = board[i] - '0';
                this.heuristic += Math.abs((num - 1) / 3 - i / 3) + Math.abs((num - 1) % 3 - i % 3);// 目标代价(manhattan)
            }
        }

        public int hashCode() {
            return board.hashCode();
        }

        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Node)) return false;
            Node n = (Node)obj;
            return this.board.equals(n.board);
        }
    }
}