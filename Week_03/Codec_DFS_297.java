/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private void dfs(TreeNode root, Deque<String> ans) {
        if(root == null) {
            if(ans.size() > 0) {
                ans.add("null");
            }
            return;
        }
        ans.add(String.valueOf(root.val));
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<String> ans = new LinkedList<>();
        dfs(root, ans);
        return ans.toString();
    }

    private TreeNode dfs(List<String> a) {
        if(a.isEmpty()) {
            return null;
        }
        String val = a.remove(0);
        if("null".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = dfs(a);
        node.right = dfs(a);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() <= 2) {
            return null;
        }
        List<String> a = Arrays.stream(data.substring(1, data.length() - 1).split(",")).map(s0-> s0.replaceAll(" ", "")).collect(Collectors.toList());
        return dfs(a);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));