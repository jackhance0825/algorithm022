class Solution {
    
     /**
      * 哈希表计数 & 优先队列
      * 时间复杂度O(nlogk)，k为堆的高度
      * 空间复杂度O(n)
      */
     public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            heap.offer(e);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}

