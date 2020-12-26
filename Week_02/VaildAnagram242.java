class Solution {
    /**
     * 快排比较
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)，String # toCharArray 需要复制数组
     */
    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }

    /**
     * 使用HashMap存储计数
     * 时间复杂度O(n)，n为max(s.length(), t.length())
     * 空间复杂度O(n)
     */
    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
        }
        return count.values().stream().allMatch(i -> i == 0);
    }

    /**
     * 使用辅助数组存储计数
     * 时间复杂度O(n)，n为max(26, s.length(), t.length())
     * 空间复杂度O(1)，count数组
     */
    public boolean isAnagram1(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(count).allMatch(i -> i == 0);
    }
}
