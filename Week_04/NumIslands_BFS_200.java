class Solution {
    /**
     * BFS
     * Time Complexity: O(m * n), m为grid.length, n为grid[i].length
     * Space Complexity: O(min(m, n)), m为grid.length, n为grid[i].length,最坏情况，queue装载的元素个数极限为min(m, n)
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int d = m > n ? m : n;
        int s = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    s++;
                    grid[i][j] = '0';
                    queue.offer(pos(i, j, d));
                    while(!queue.isEmpty()) {
                        int a = queue.poll();
                        int x = a / d;
                        int y = a % d;
                        offerPos(x - 1, y, m, n, d, queue, grid);
                        offerPos(x + 1, y, m, n, d, queue, grid);
                        offerPos(x, y - 1, m, n, d, queue, grid);
                        offerPos(x, y + 1, m, n, d, queue, grid);
                    }
                }
            }
        }
        return s;
    }

    private void offerPos(int x, int y, int m, int n, int d, Queue<Integer> queue, char[][] grid) {
        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
            queue.offer(pos(x, y, d));
            grid[x][y] = '0';
        }
    }

    private int pos(int x, int y, int d) {
        return x * d + y;
    }
}