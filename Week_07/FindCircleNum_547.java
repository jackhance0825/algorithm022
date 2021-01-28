class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[count = n];
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
            int pp = find(p);
            int pq = find(q);
            if(pp == pq) return;
            parent[pp] = pq;
            count--;
        }
    }
}