package fly.leetcode.cn.q544;

/**
 * 数学：3的幂次质因子只有3
 * 此外因为题解范围有限，可以使用打表来解决问题
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        //1162261467 = 2^19,3的幂的因数必然是3的幂
        return n > 0 && 1162261467 % n == 0;
    }
}