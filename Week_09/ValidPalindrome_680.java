class Solution {
    public boolean validPalindrome(String s) {
        return s == null || s.length() == 0 || valid(s, 0, s.length() - 1, 1);
    }

    private boolean valid(String s, int left, int right, int del) {
        if(left >= right) return true;
        while(left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return del == 0 ? left >= right : valid(s, left + 1, right, del - 1) || valid(s, left, right - 1, del - 1);
    }
}