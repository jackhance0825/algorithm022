class Solution {
    public String toLowerCase(String str) {
        if(str == null || str.length() == 0) return str;
        char[] cs = str.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            cs[i] = cs[i] <= 'Z' && cs[i] >= 'A' ? (char)(cs[i] - 'A' + 'a') : cs[i];
        }
        return new String(cs);
    }
}