class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        int left = 0, right = s.length() - 1;
        while(left < right) {
            char lc = '#';
            while(left <= right && (lc = isLetter(s.charAt(left))) == '#') left++;
            char rc = '#';
            while(left <= right && (rc = isLetter(s.charAt(right))) == '#') right--;
            if(lc != rc) return false;
            left++;
            right--;
        }
        return true;
    }

    private char isLetter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ? c :
        c >= 'A' && c <= 'Z' ? (char)(c - 'A' + 'a') : '#';
    }
}