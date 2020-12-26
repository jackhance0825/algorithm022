class Solution {
    /**
     * 哈希表，使用快排后的字符串作为key，来汇总
     * 时间复杂度O(n * klogk)，n为字符集数，k为字符串最大长度
     * 空间复杂度O(n)，HashMap、String#toCharArray、ArrayList消耗
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> list = map.get(key);
            if(list == null) {
                map.put(key, list = new LinkedList());
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
