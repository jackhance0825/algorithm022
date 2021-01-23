class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] > 1) return false;
        // 记录到达每个石头的所有有可能的k值
        Map<Integer, Set<Integer>> posKs = new HashMap<>(stones.length, 1f);
        for(int stone : stones) {
            posKs.put(stone, new HashSet<>());
        }
        int dest = stones[stones.length - 1];
        posKs.get(1).add(1);
        for(int i = 1; i < stones.length; i++) {
            int pos = stones[i];
            for(int k0 : posKs.get(pos)) {
                for(int k = k0 - 1; k <= k0 + 1; k++) {
                    if(k <= 0) continue;
                    if(pos + k == dest) return true;
                    Set<Integer> ks0 = posKs.get(pos + k);
                    if(ks0 != null) ks0.add(k);
                }
            }
        }
        return stones.length <= 2;
    }
}