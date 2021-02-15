class Solution {
    public String reverseWords(String s) {
        // 去掉前后空格
        int b = 0;
        int e = s.length() - 1;
        while(b < e && s.charAt(b) == ' ') b++;
        while(b < e && s.charAt(e) == ' ') e--;
        // 计算数组长度
        int len = 0;
        for(int i = b; i <= e; i++) {
            if(s.charAt(i) == ' ' && i - 1 >= 0 && s.charAt(i - 1) == ' ') continue;
            len++;
        }
        // 复制数据
        char[] cs = new char[len];
        int pos = 0;
        for(int i = b; i <= e; i++) {
            if(s.charAt(i) == ' ' && i - 1 >= 0 && s.charAt(i - 1) == ' ') continue;
            cs[pos++] = s.charAt(i);
        }
        // 反转
        for(int i = 0; i < len / 2; i++) {
            char temp = cs[i];
            cs[i] = cs[len - 1 - i];
            cs[len - 1 - i] = temp;
        }
        // 反转单个单词
        for(int i = 0; i < cs.length; ) {
            b = i;
            while(i < cs.length && cs[i] != ' ') i++;
            e = i - 1;
            while(b < e) {
                char temp = cs[b];
                cs[b] = cs[e];
                cs[e] = temp;
                b++;
                e--;
            }
            while(i < cs.length && cs[i] == ' ') i++;
        }
        return new String(cs);
    }
}