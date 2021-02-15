class Solution {
    /**
    * 排序
    */
    public boolean isAnagram(String s, String t) {
        if((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
        if(s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    /**
    * 哈希表
    */
    public boolean isAnagram1(String s, String t) {
        if((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if(count == null) return false;
            if(count == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), count - 1);
            }
        }
        return map.isEmpty();
    }
}