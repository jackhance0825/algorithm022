public class Solution {
    public int hammingWeight(int n) {
        int c = 0;
        int mask = 1;
        for(int shift = 0; shift < 32; shift++) {
            if((n & mask) != 0) c++;
            mask <<= 1;
        }
        return c;
    }
    
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int c = 0;
        while(n != 0) {
            n &= n - 1;
            c++;
        }
        return c;
    }
}