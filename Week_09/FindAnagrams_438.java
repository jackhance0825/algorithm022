class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        int[] need = new int[26];// 需要数量
        int needSize = 0;// 需要种类数
        for(int i = 0; i < p.length(); i++) {
            if(need[p.charAt(i) - 'a']++ == 0) needSize++;
        }
        int left = 0// 左界
        , right = 0// 右界
        , valid = 0;// 窗口累计有效种类数
        int[] window = new int[26];// 窗口数量
        while(right < s.length()) {
            char c = s.charAt(right++);
            if(need[c - 'a'] > 0 && ++window[c - 'a'] == need[c - 'a']) valid++;// 移动右界
            while(valid == needSize) {// 窗口种类数符合需求
                if(right - left == p.length()) res.add(left);// 长度匹配，即符合异位
                c = s.charAt(left++);
                if(window[c - 'a'] > 0 && window[c - 'a']-- == need[c - 'a']) valid--;// 移动左界
            }
        }
        return res;
    }
}