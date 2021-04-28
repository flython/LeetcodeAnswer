package fly.leetcode.cn.q363;

import java.util.Arrays;

/**
 * matrix = [
 *          [1, 0,1,7,8,9],
 *          [0,-2,3,4,5,6]
 *          ]
 *
 *  看错了，矩形不一定是正方形
 *  但是这里的元素又有大有小，那我怎么知道如何是最小
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        return countAsRow(matrix,k,matrix[0].length,matrix.length);
    }

    //纵向压缩，把所有行压缩成一行
    private int countAsRow(int[][] matrix,int k,int rowLen, int colLen){
        for (int c = 0; c < rowLen; c++) {
            for (int r = 1; r < colLen; r++) {
                matrix[0][c] += matrix[r][c];
            }
        }
        //第一行为每一列的合计
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < colLen; i++) {
            sum+=matrix[0][i];
        }

        if (sum <= k){
            res = Math.max(res,sum);
        }

        for(int i = colLen; i < rowLen; i++){
            sum += matrix[0][i];
            sum -= matrix[0][i-colLen];
            if (sum <= k){
                res = Math.max(res,sum);
            }
            if (res == k){
                return k;
            }
        }
        return res;
    }
}
