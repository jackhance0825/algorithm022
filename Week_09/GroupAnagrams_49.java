class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap();
        for(String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> list = map.get(key);
            if(list == null) map.put(key, list = new LinkedList<>());
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }
}