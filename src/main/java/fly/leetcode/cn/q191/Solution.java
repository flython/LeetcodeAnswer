package fly.leetcode.cn.q191;


public class Solution {
    //0x55555555
    public static final int M1 = 0b01010101010101010101010101010101;
    //0x33333333
    public static final int M2 = 0b00110011001100110011001100110011;
    //0xf0f0f0f
    public static final int M4 = 0b00001111000011110000111100001111;

    // 参考Integer::bitCount()
    public int hammingWeight(int i) {
        // step=2 二分相加
        i = (i & M1) + ((i >>> 1) & M1);
        i = (i & M2) + ((i >>> 2) & M2);
        i = (i & M4) + ((i >>> 4) & M4);
        i = i + i>>>8;
        i = i + i>>>16;
        return i & 0b111111;

    }


}