package fly.leetcode.interview.q0801;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 分析：
 *      因为可以有三种选择，所以对于n > 3,可以选择的情况为
 *                                  1 按照f(2) 再走3阶
 *                                  2 按照f(3) 再走2阶
 *                                  3 按照f(4) 再走1阶
 *      f(5) = f(4) + f(3) + f(2)
 *      f(n) = f(n-1) + f(n-2) + f(n-3) (n < 3)
 *
 */
class Solution {
    public static final int mod = 1000_000_007;

    public static final int[] cache = new int[10000001];
    static {
        cache[1] = 1+1;
        cache[2] = 2+1;
        cache[3] = 4+1;
        Solution solution = new Solution();
        for (int i = 1; i <= 1000000; i++) {
            solution.waysToStep(i);
        }
    }

    public int waysToStep(int n) {
        int history = cache[n]-1;
        if (history != -1){
            return history;
        }
        int res = (waysToStep(n-3) + waysToStep(n-2))%mod;
        res =  (res + waysToStep(n-1)) % mod;
        cache[n] = res+1;
        return res;
    }

}
