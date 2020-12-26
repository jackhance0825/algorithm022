/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /**
     * 递归
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new LinkedList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        if(root.children != null) {
            for(Node child : root.children) {
                preorder(child, result);
            }
        }
    }

    /**
     * 迭代
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.pollLast();
            result.add(node.val);
            if(node.children != null) {
                Collections.reverse(node.children);
                for(Node child : node.children) {
                    queue.offer(child);
                }
            }
        }
        return result;
    }
}
