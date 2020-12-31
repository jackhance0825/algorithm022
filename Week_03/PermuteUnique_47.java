class Solution {
    private void permuteUnique(List<List<Integer>> ans, Deque<Integer> path, boolean[] visited, int[] nums) {
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        Integer last = null;
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i] && (last == null || last != nums[i])) {
                last = nums[i];
                visited[i] = true;
                path.offer(nums[i]);
                permuteUnique(ans, path, visited, nums);
                path.pollLast();
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        permuteUnique(ans, path, visited, nums);
        return ans;
    }
}