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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] s = new int[2];
        dfs(root, s);
        return Math.max(s[0], s[1]);// s[0]当前节点不偷的最大金额，s[1]当前节点偷的最大金额
    }

    private void dfs(TreeNode root, int[] s) {
        if(root == null) {
            s[0] = s[1] = 0;
            return;
        }
        dfs(root.left, s);
        int steal1 = s[1];
        int unsteal1 = s[0];
        dfs(root.right, s);
        int steal2 = s[1];
        int unsteal2 = s[0];

        s[0] = Math.max(steal1, unsteal1) + Math.max(steal2, unsteal2);// 当前节点不偷，左右子结点可偷可不偷
        s[1] = root.val + unsteal1 + unsteal2;// 当前节点偷，左右子结点不偷
    }
}