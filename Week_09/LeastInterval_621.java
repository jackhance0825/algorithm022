class Solution {
    /**
    * A B CD
    * A B CD
    * A B
    */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }
        int max = 0;
        for(int c : count) {
            max = Math.max(c, max);
        }
        int maxCount = 0;
        for(int c : count) {
            if(c == max) maxCount++;
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}