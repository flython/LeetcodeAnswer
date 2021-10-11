package fly.leetcode.lcp.lcp47;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
class Solution {
    public static final int mod = 1000000007;
    public int securityCheck(int[] capacities, int k) {
        //1 确定dp数组，使用一维数组存储对象
        int[] table = new int[k+1];
        //3 初始化dp数组，初始化表
        table[0] = 1;
        for (int capacity : capacities) {
            //ps,当capacity = 1 时，其实选队列还是栈都一样，所以会有两种选择
            for (int i = table.length - 1; i >= 0; i--) {
                // 2 确定递推公式：设x坐标为k的选择，y坐标为capacities，table[y][x] = table[y-1][x] + table[y-1][x-val(y)]
                // 由于操作都在上一行，所以可以通过反向遍历优化
                int asStackPreIndex = i-capacity+1;
                table[i] = (table[i] + (asStackPreIndex<0?0:table[asStackPreIndex])) % mod;
            }
            log.info("cap={},tab={}",capacity, Arrays.toString(table));
        }
        return table[k];
    }
}
