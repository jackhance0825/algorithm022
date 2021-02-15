class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; ) {
            int b = i;
            int e = i;
            while(e + 1 < cs.length && cs[e + 1] != ' ') e++;
            for(int j = b; j <= b + (e - b) / 2; j++) {
                char temp = cs[j];
                cs[j] = cs[e - (j - b)];
                cs[e - (j - b)] = temp;
            }
            i = e + 1;
            while(i < cs.length && cs[i] == ' ') i++;
        }
        return new String(cs);
    }
}