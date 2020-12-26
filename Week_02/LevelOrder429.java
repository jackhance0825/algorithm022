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
     * 迭代
     * 时间复杂度O(n)，n为节点数
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            while(size-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                if(node.children != null) {
                    for(Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 递归
     * 时间复杂度O(n)，n为节点数
     * 空间复杂度O(logn)，n为调用堆栈消耗
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        levelOrder(root, 0, ans);
        return ans;
    }

    private void levelOrder(Node root, int level, List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        if(ans.size() < level + 1) {
            ans.add(new LinkedList<>());
        }
        ans.get(level).add(root.val);
        if(root.children != null) {
            for(Node child : root.children) {
                levelOrder(child, level + 1, ans);
            }
        }
    }

}
