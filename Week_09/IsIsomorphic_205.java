class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> k2v = new HashMap<>();
        Map<Character, Character> v2k = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            Character ct0 = k2v.put(cs, ct);
            if(ct0 != null && ct0 != ct) return false;
            Character cs0 = v2k.put(ct, cs);
            if(cs0 != null && cs0 != cs) return false;
        }
        return true;
    }
}