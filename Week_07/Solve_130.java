class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        int edgeZero = m * n;// 边上的O的组号
        UnionFind uf = new UnionFind(m * n + 1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != 'O') continue;
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) uf.union(i * n + j, edgeZero);
                if(i > 0 && board[i - 1][j] == 'O') uf.union(i * n + j, (i - 1) * n + j);
                if(i < m - 1 && board[i + 1][j] == 'O') uf.union(i * n + j, (i + 1) * n + j);
                if(j > 0 && board[i][j - 1] == 'O') uf.union(i * n + j, i * n + j - 1);
                if(j < n - 1 && board[i][j + 1] == 'O') uf.union(i * n + j, i * n + j + 1);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && uf.find(i * n + j) != uf.find(edgeZero)) board[i][j] = 'X';
            }
        }
    }

    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
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
        }
    }
}