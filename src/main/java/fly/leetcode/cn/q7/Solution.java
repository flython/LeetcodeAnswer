package fly.leetcode.cn.q7;

/**
 * 按十进制的整数反转，符号保留
 *
 */
class Solution {
    public int reverse(int x) {
        int n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (n&0x8000)==(x&0x8000)?n:0;
    }
}