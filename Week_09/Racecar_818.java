class Solution {
    /**
    * DP
    * DP[i] : 走到i位置的最短指令列表长度
    */
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for(int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int forward = 0, forDis = 1; forDis < 2 * i; forDis = (1 << (++forward)) - 1) {
                if(forDis == i) {// 0AAA.. : 0位置出发，一直向前
                    dp[i] = forward;
                } else if(forDis > i) {// 0AAA..RAA.. : 0位置出发，越过了i，R回头（+1），走距离forDis - i
                    dp[i] = Math.min(dp[i], forward + 1 + dp[forDis - i]);
                } else {// KAAA..RAA.RAA. : K位置出发，R回头俩遍
                    for(int back = 0; back < forward; back++) {
                        int backDis = (1 << back) - 1;
                        dp[i] = Math.min(dp[i], forward + 1 + back + 1 + dp[backDis - forDis + i]);
                    }
                }
            }
        }
        return dp[target];
    }
    
    /**
    * Dijkstra
    */
    public int racecar1(int target) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.heuristic - b.heuristic);
        Set<String> visited = new HashSet<>();// 已访问节点
        queue.offer(new Node(0, 1, 0, target));
        visited.add("0-1");
        while(true) {
            Node n = queue.poll();
            if(n.pos + n.speed == target) return n.len + 1;// 找到目标
            // 0-A, 1-R
            for(int i = 0; i <= 1; i++) {
                int pos = i == 0 ? n.pos + n.speed : n.pos;
                int speed = i == 0 ? n.speed * 2 : n.speed > 0 ? -1 : 1;
                if(pos > 0 && pos < 2 *target && !visited.contains(pos + "-" + speed)) {
                    queue.offer(new Node(pos, speed, n.len + 1, target));
                    visited.add(pos + "-" + speed);
                }    
            }
        }
    }

    private class Node {
        int pos;
        int speed;
        int len;
        int heuristic;

        Node(int pos, int speed, int len, int target) {
            this.pos = pos;
            this.speed = speed;
            this.len = len;
            this.heuristic = len;// 当前代价
        }
    }
}