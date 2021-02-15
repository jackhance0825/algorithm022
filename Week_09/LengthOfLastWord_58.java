class Solution {
    public int lengthOfLastWord(String s) {
        int e = s.length() - 1;
        while(e >= 0 && s.charAt(e) == ' ') e--;
        if(e < 0) return 0;
        int b = e;
        while(b >= 0 && s.charAt(b) != ' ') b--;
        return e - b;
    }
    
    public int lengthOfLastWord1(String s) {
        int b = -1 , e = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                if(i - 1 >= 0 && s.charAt(i - 1) == ' ') b = e = -1;
                b = b == -1 ? i : b;
                e = i;
            }
        }
        return b == -1 ? 0 : e - b + 1;
    }
}