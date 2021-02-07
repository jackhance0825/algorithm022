public class Solution {
    /**
    * divide conquer
    */
    public int reverseBits(int n) {
        n = ((0xFFFF0000 & n) >>> 16) | ((0x0000FFFF & n) << 16);
        n = ((0xFF00FF00 & n) >>> 8) | ((0x00FF00FF & n) << 8);
        n = ((0xF0F0F0F0 & n) >>> 4) | ((0x0F0F0F0F & n) << 4);
        n = ((0xCCCCCCCC & n) >>> 2) | ((0x33333333 & n) << 2);// 1100->C 0011->3
        n = ((0xAAAAAAAA & n) >>> 1) | ((0x55555555 & n) << 1);// 1010->A 0101->5
        return n;
    }

    // you need treat n as an unsigned value
    public int reverseBits1(int n) {
        int res = 0;
        int mask = 1;
        for(int i = 1; i <= 32; i++) {
            if((n & mask) != 0) res |= 1 << (32 - i);
            mask <<= 1;
        }
        return res;
    }
}