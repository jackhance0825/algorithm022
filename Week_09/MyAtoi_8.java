class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;
        // trimLeft
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        // 符号
        int sign = 1;
        if(i < s.length()) {
            if(s.charAt(i) == '+') {
                i++;
            } else if(s.charAt(i) == '-') {
                i++;
                sign = -1;
            }
        }
        // 数字部分
        long res = 0;
        for( ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') break;
            res = res * 10 + (c - '0');
            if(res > Integer.MAX_VALUE) {
                res = sign == -1 ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
                break;
            }
        }
        return (int)(res * sign);
    }
}