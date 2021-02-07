class Solution {
    /**
    * Bucket Sort
	* Time Complexity: O(nlogn)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int j = 0;
        for(int i = 0; i < arr2.length; i++) {
            Integer c = map.remove(arr2[i]);
            while(c != null && c-- > 0) arr1[j++] = arr2[i];
        }
        Map.Entry<Integer, Integer> entry = null;
        while((entry = map.pollFirstEntry()) != null) {
            Integer c = entry.getValue();
            while(c != null && c-- > 0) arr1[j++] = entry.getKey();
        }
        return arr1;
    }

    /**
    * Count Sort
    * Time Complexity: O(n + k), k为元素种类数，n为数组最大长度
    */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int max = 10000;
        int[] temp = new int[max + 1];
        for(int a : arr1) temp[a]++;
        int j = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(temp[arr2[i]]-- > 0) arr1[j++] = arr2[i];
        }
        for(int i = 0; i <= max; i++) {
            while(temp[i]-- > 0) arr1[j++] = i;
        }
        return arr1;
    }
}