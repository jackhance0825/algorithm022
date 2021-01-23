class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long A0L0 = 1, // ..P
		A0L1 = 0, // ..PL
		A0L2 = 0, // ..PLL
		A1L0 = 0, // ..A
		A1L1 = 0, // ..A..L
		A1L2 = 0; // ..A..LL
        for(int i = 0; i < n; i++) {
            long _A0L0 = (A0L0 + A0L1 + A0L2) % M;
            long _A0L1 = A0L0;
            long _A0L2 = A0L1;
            long _A1L0 = (_A0L0 + A1L0 + A1L1 + A1L2) % M;
            long _A1L1 = A1L0;
            long _A1L2 = A1L1;

            A0L0 = _A0L0;
            A0L1 = _A0L1;
            A0L2 = _A0L2;
            A1L0 = _A1L0;
            A1L1 = _A1L1;
            A1L2 = _A1L2;
        }
        return (int)((A0L0 + A0L1 + A0L2 + A1L0 + A1L1 + A1L2) % M);
    }
}