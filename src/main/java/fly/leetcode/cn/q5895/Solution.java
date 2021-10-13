package fly.leetcode.cn.q5895;

import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] minMax = {Integer.MAX_VALUE,Integer.MIN_VALUE};
        int[] ints = Arrays.stream(grid).flatMapToInt(Arrays::stream).peek(i->{
            minMax[0] = Math.min(minMax[0],i);
            minMax[1] = Math.max(minMax[1],i);
        }).toArray();

        int mid = (minMax[0]+minMax[1])>>1;

        return 0;

    }
}
