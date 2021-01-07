class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands.length == 0) return 0;
        Set<Long> obstaclesSet = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obstaclesSet.add(pos(obstacle[0], obstacle[1]));
        }
        int ans = 0;
        int x = 0;
        int y = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int side = 3;// 东南西北，0-3
        for(int i = 0; i < commands.length; i++) {
            if(commands[i] == -2) {// left
                side = side == 0 ? 3 : --side;
            } else if(commands[i] == -1) {// right
                side = side == 3 ? 0 : ++side;
            } else {// go straight
                boolean moveX = (side & 1) == 0;
                int start = moveX ? x : y;
                int end = side % 3 == 0 ? start + commands[i] : start - commands[i];
                int[] d = moveX ? dx : dy;
                int a = start;
                for(; a != end; a += d[side]) {
                    int x0 = moveX ? a + d[side] : x;
                    int y0 = moveX ? y : a + d[side];
                    if(obstaclesSet.contains(pos(x0, y0))) break;
                }
                x = moveX ? a : x;
                y = moveX ? y : a;
                ans = Math.max(ans, x * x + y * y);
            }
        }
        return ans;
    }

    private Long pos(int x, int y) {
        long spin = 30000;
        return x + spin + (y + spin) * 2 * spin;
    }
}