/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, root, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, TreeNode root, int level) {
        if(root == null) return;
        if(ans.size() < level) ans.add(new LinkedList<>());
        ans.get(level - 1).add(root.val);
        dfs(ans, root.left, level + 1);
        dfs(ans, root.right, level + 1);
    }
}