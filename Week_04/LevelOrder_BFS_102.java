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
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int s = queue.size();
            List<Integer> level = new ArrayList<>(s);
            while(s-- > 0) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }
            ans.add(level);
        }
        return ans;
    }
}