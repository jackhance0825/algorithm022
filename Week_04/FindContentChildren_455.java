class Solution {
    /**
    * greedy, 最大的饼干优先满足胃口最大的小孩，后续的饼干能够满足更多的小孩，最优子结构为全局最优
    * Time Complexity: O(mlogm + nlogn), m为g.length，n为s.length
    * Space Complexity: O(1)，快排为原地排序，所以空间复杂度为O(1)
    */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = 0;
        for(int si = s.length - 1, gi = g.length - 1; gi >= 0 && si >= 0; gi--) {
            if(s[si] >= g[gi]) {
                n++;
                si--;
            }
        }
        return n;
    }
}