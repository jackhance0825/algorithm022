class Solution {
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() == 0) return S;
        char[] cs = new char[S.length()];
        for(int left = 0, p = 0, right = S.length() - 1; left < S.length(); left++) {
            char c = S.charAt(left);
            if(isLetter(c)) {
                while(!isLetter(S.charAt(right))) right--;
                c = S.charAt(right--);
            }
            cs[p++] = c;
        }
        return new String(cs);
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}