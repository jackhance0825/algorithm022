class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
	/**
    * UnionFind
    * TimeComplexity: O(MN * α(MN)), M为grid.length, N为grid[0].length, α(MN)为反阿克曼函数，不超过5，可认作为常数
    * SpaceComplexity: O(MN)
    */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    for(int k = 0; k < 4; k++) {
                        int i0 = i + dx[k];
                        int j0 = j + dy[k];
                        if(i0 < 0 || i0 >= m || j0 < 0 || j0 >= n || grid[i0][j0] == '0') continue;
                        uf.union(i0 * n + j0, i * n + j);
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    } else {
                        parent[i * n + j] = -1;
                    }
                }
            }
        }

        public int find(int p) {
            while(p != parent[p]) {
                p = parent[p] = parent[parent[p]];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }


    /**
    * DFS染色
    */
    public int numIslands1(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    c++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return c;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}