class Solution {
    /**
    * A*
    */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if(n <= 1) return 1;
        int[][] step = new int[n][n];
        step[0][0] = 1;
        Queue<Pos> queue = new PriorityQueue<>((a, b) -> a.heuristic - b.heuristic);
        queue.offer(new Pos(0, 0, 1, n));
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            for(int i = 0; i < 8; i++) {
                int x0 = p.x + dx[i];
                int y0 = p.y + dy[i];
                if(x0 == n - 1 && y0 == n - 1) return p.len + 1;
                if(x0 < 0 || x0 >= n || y0 < 0 || y0 >= n || grid[x0][y0] == 1) continue;
                if(step[x0][y0] > 0 && step[x0][y0] <= p.len + 1) continue;
                queue.offer(new Pos(x0, y0, step[x0][y0] = p.len + 1, n));
            }
        }
        return -1;
    }

    /**
    * Two-End BFS
    */
    public int shortestPathBinaryMatrix2(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if(n <= 1) return 1;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Set<Pos> begins = new HashSet<>();
        Set<Pos> ends = new HashSet<>();
        begins.add(new Pos(0, 0));
        ends.add(new Pos(n - 1, n - 1));
        int len = 1;
        while(!begins.isEmpty() && !ends.isEmpty()) {
            if(begins.size() > ends.size()) {
                Set<Pos> temp = begins;
                begins = ends;
                ends = temp;
            }
            Set<Pos> temp = new HashSet<>();
            for(Pos p : begins) {
                for(int i = 0; i < 8; i++) {
                    int x0 = p.x + dx[i];
                    int y0 = p.y + dy[i];
                    if(x0 < 0 || x0 >= n || y0 < 0 || y0 >= n || grid[x0][y0] == 1) continue;
                    Pos np = new Pos(x0, y0);
                    if(ends.contains(np)) return len + 1;
                    if(visited[x0][y0]) continue;
                    temp.add(np);
                    visited[x0][y0] = true;
                }
            }
            begins = temp;
            len++;
        }
        return -1;
    }

    /**
    * BFS
    */
    public int shortestPathBinaryMatrix1(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if(n <= 1) return 1;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));
        int len = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Pos p = queue.poll();
                for(int i = 0; i < 8; i++) {
                    int x0 = p.x + dx[i];
                    int y0 = p.y + dy[i];
                    if(x0 == n - 1 && y0 == n - 1) return len + 1;
                    if(x0 < 0 || x0 >= n || y0 < 0 || y0 >= n || visited[x0][y0] || grid[x0][y0] == 1) continue;
                    queue.offer(new Pos(x0, y0));
                    visited[x0][y0] = true;
                }
            }
            len++;
        }
        return -1;
    }

    int[] dx = new int[]{0 , 0, -1, 1, -1, 1, -1, 1};
    int[] dy = new int[]{1 , -1, 0, 0, -1, 1, 1, -1};
    class Pos {
        int x;
        int y;
        int len;
        int heuristic;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pos(int x, int y, int len, int n) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.heuristic = heuristic(n);
        }

        private int heuristic(int n) {
            int curCost = len;// 当前代价
            int destCost = Math.max(n - 1 - x, n - 1 - y);// 目标代价
            return curCost + destCost;
        }

        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(!(obj instanceof Pos)) return false;
            Pos p = (Pos)obj;
            return p.x == this.x && p.y == this.y;
        }

        public int hashCode() {
            return x + 100 * y;
        }
    }
}