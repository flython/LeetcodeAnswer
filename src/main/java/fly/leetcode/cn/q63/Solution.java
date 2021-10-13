package fly.leetcode.cn.q63;

import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //初始化

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇到石头时，设置为0表示此路不通
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0){
                    obstacleGrid[0][0] = 1;
                } else {
                    obstacleGrid[i][j] = (i==0?0:obstacleGrid[i-1][j]) + (j==0?0:obstacleGrid[i][j-1]);
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
