class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();// 记录每个石头的k值
        for(int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1);
        for(int stone : stones) {
            for(int k : map.get(stone)) {
                Set<Integer> ks = map.get(k + stone);
                if(ks == null) continue;
                if(k - 1 > 0) ks.add(k - 1);
                ks.add(k);
                ks.add(k + 1);
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();// 最后一块石头k不为空，则能到达最后一个石头
    }
}