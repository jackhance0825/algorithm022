class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        if(jewels == null || jewels.length() == 0 || stones == null || stones.length() == 0) return 0;
        boolean[] j = new boolean[52];
        for(int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            j[c < 'a' ? c - 'A' + 26 : c - 'a'] = true;
        }
        int count = 0;
        for(int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if(j[c < 'a' ? c - 'A' + 26 : c - 'a']) count++;
        }
        return count;
    }
}