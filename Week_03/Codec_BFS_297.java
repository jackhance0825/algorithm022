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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<String> ans = new LinkedList<>();
        if(root == null) {
            return ans.toString();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            boolean isNonNull = false;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                ans.add(node == null ? "null" : String.valueOf(node.val));
                if(node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    isNonNull |= node.left != null || node.right != null;
                }
            }
            if(!isNonNull) break;
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() <= 2) {
            return null;
        }
        String[] a = Arrays.stream(data.substring(1, data.length() - 1).split(",")).map(s0-> s0.replaceAll(" ", "")).toArray(String[]::new);
        TreeNode root = new TreeNode(Integer.valueOf(a[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode n = queue.poll();
                if(n != null) {
                    int left = cur++;
                    int right = cur++;
                    if(left < a.length) {
                        n.left = "null".equals(a[left]) ? null : new TreeNode(Integer.valueOf(a[left]));
                        queue.offer(n.left);
                    }
                    if(right < a.length) {
                        n.right = "null".equals(a[right]) ? null : new TreeNode(Integer.valueOf(a[right]));
                        queue.offer(n.right);
                    }
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));