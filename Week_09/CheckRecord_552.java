class Solution {
    final long M = 1000000007L;
    public int checkRecord(int n) {
        long A0L0 = 1, A0L1 = 0, A0L2 = 0, A1L0 = 0, A1L1 = 0, A1L2 = 0;
        for(int i = 0; i < n; i++) {
            long _A0L0 = (A0L0 + A0L1 + A0L2) % M;
            long _A1L0 = _A0L0 + (A1L0 + A1L1 + A1L2) % M;
            
            A0L2 = A0L1;
            A0L1 = A0L0;

            A1L2 = A1L1;
            A1L1 = A1L0;

            A0L0 = _A0L0;
            A1L0 = _A1L0;
        }
        return (int)(((A0L0 + A0L1 + A0L2) % M + (A1L0 + A1L1 + A1L2) % M) % M);
    }
}