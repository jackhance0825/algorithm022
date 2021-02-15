class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int j = 1;
            for(; j < strs.length && i < strs[j].length(); j++) {
                if(c != strs[j].charAt(i)) break;
            }
            if(j < strs.length) break;
            s.append(c);
        }
        return s.toString();
    }
}