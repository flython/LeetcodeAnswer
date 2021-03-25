package fly.leetcode.cn.q73;

import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;

class Solution {
    public void setZeroes(int[][] matrix) {
        int[] baseZero = null;
        BitSet cols = new BitSet(matrix[0].length);
        LinkedList<int[]> noneZeros = new LinkedList<>();

        for (int m = 0; m < matrix.length; m++) {
            int[] row = matrix[m];
            boolean rowShouldZero = false;

            for (int n = 0; n < row.length; n++) {
                if (row[n] == 0) {
                    if (!cols.get(n)) {
                        //由于增加了新的0列，需要对以后的非0行进行赋0操作
                        for (int[] noneZero : noneZeros) {
                            noneZero[n] = 0;
                        }
                    }
                    //记录当前列需要置0
                    cols.set(n);
                    rowShouldZero = true;
                }
                //在第一次循环就顺便赋值
                if (!rowShouldZero&&cols.get(n)){
                    row[n] = 0;
                }
            }

            if (rowShouldZero) {
                if (baseZero == null) {
                    //以当前行为基准0
                    baseZero = row;
                } else {
                    //当前行直接替换成基准行
                    matrix[m] = baseZero;
                }
            } else {
                noneZeros.add(row);
            }
        }
        Arrays.fill(baseZero,0);
    }
}
