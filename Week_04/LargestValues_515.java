/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int width = queue.size();
            int max = Integer.MIN_VALUE;
            while(width-- > 0) {
                TreeNode n = queue.poll();
                max = Math.max(n.val, max);
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }
            ans.add(max);
        }
        return ans;
    }
}