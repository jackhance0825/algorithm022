class Solution {
    /**
    * slide window
    */
    public String minWindow(String s, String t) {
        int[] win = new int[52];
        int[] need = new int[52];
        int needSize = 0, valid = 0;
        for(int i = 0; i < t.length(); i++) {
            if(need[pos(t.charAt(i))]++ == 0) needSize++;
        }
        int left0 = -1, right0 = -1;
        for(int left = 0, right = 0; right < s.length(); ) {
            char c = s.charAt(right++);
            if(need[pos(c)] > 0 && ++win[pos(c)] == need[pos(c)]) valid++;// 移动右界，覆盖子串
            while(valid == needSize) {// 覆盖后，收窄左界
                c = s.charAt(left++);
                if(need[pos(c)] > 0 && win[pos(c)]-- == need[pos(c)]) {
                    valid--;
                    if(left0 == -1 || right0 - left0 > right - left + 1) {
                        left0 = left - 1;
                        right0 = right;
                    }
                }
            }
        }
        return left0 == -1 ? "" : s.substring(left0, right0);
    }

    private int pos(char c) {
        return c < 'a' ? c - 'A' : c - 'a' + 26;
    }
}