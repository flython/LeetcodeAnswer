package fly.leetcode.cn.q62;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        //1 确定数组：下标为网格xy坐标
        //2 递推公式：走到目标上面的格子和走到目标左边的格子，都能一步走到目标，所以 v(x,y) = v(x-1,y) + v(y,x-1), 当某个下标为-1时，结果为0
        //3，初始化，由2的最后条件可知，第一行，第一列永远为1
        int[] dp = new int[m];
        Arrays.fill(dp,1);
        //因为第一行已经填好，所以从第二行开始
        for (int j = 1; j < n; j++) {
            //因为每一行第一个已经填好，所以每一行从第二个开始
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i-1] + dp[i];
            }
        }
        return dp[m-1];
    }
}
