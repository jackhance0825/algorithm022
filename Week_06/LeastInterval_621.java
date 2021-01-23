class Solution {
	// (桶数量-1) × (桶容积即n+1) + 最后一个桶的装载量
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char task : tasks) {
            c[task - 'A']++;
        }
        int max = 0;
        for(int c0 : c) {
            max = Math.max(c0, max);
        }
        int maxCount = 0;
        for(int c0 : c) {
            if(c0 == max) maxCount++;
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}