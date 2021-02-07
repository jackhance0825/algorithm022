class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if(s >= e) return 0;
        int m = s + ((e - s) >> 1);
        int c = mergeSort(nums, s, m) + mergeSort(nums, m + 1, e);
        
        for(int i = s, j = m + 1; i <= m; i++) {
            while(j <= e && nums[i] > 2L * nums[j]) j++;
            c += j - m - 1;
        }
        
        int[] temp = new int[e - s + 1];
        for(int i = s; i <= e; i++) {
            temp[i - s] = nums[i];
        }
        int left = s;
        int right = m + 1;
        for(int i = s; i <= e; i++) {
            nums[i] = right > e || (left <= m && temp[-s + left] < temp[-s + right]) 
                        ? temp[-s + left++] : temp[-s + right++];
        }
        return c;
    }
}