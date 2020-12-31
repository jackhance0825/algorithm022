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
    private TreeNode dfs(int[] p, int[] i, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
        if(ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(p[ps]);
        int index = map.get(root.val);
        root.left = dfs(p, i, ps + 1, index - is + ps, is, index - 1, map);
        root.right = dfs(p, i, index - is + ps + 1, pe, index + 1, ie, map);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
}