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
    * 迭代
    * 时间复杂度O(n)
    */ 
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Integer inorder = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(inorder != null && inorder >= root.val) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    
    /** 
    * recursive
    * 时间复杂度O(n)
    */ 
    public boolean isValidBST1(TreeNode root) {
        if(root == null) {
            return true;
        }
        return recursive(root, null, null);
    }

    private boolean recursive(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        if((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
    }
}