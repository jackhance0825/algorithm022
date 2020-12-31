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
    /**
    * BFS
    */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return deep;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return deep;
    }


    /**
    * recursive
    * 时间复杂度O(n)
    */
    public int minDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(TreeNode root, int level) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null) {
            return level;
        }
        return Math.min(dfs(root.left, level + 1), dfs(root.right, level + 1));
    }
}