class Solution {
    private void permute(int[] nums, List<List<Integer>> ans, Deque<Integer> q, boolean[] visted) {
        if(q.size() == nums.length) {
            ans.add(new ArrayList<>(q));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visted[i]) {
                visted[i] = true;
                q.offer(nums[i]);
                permute(nums, ans, q, visted);
                q.pollLast();
                visted[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> q = new LinkedList<>();
        boolean[] visted = new boolean[nums.length];
        permute(nums, ans, q, visted);
        return ans;
    }
}