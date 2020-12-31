class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, new LinkedList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> path, int[] nums, int i) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        backtrack(ans, path, nums, i + 1);
        path.add(nums[i]);
        backtrack(ans, path, nums, i + 1);
        path.remove(path.size() - 1);
    }
}