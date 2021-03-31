package fly.leetcode.cn.q240;

/**
 *
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        for (int i = 0; i <= rows; i++) {
            if (matrix[i][0] == target || matrix[i][cols] ==target){
                return true;
            } else if (matrix[i][0] < target &&  target < matrix[i][cols]){

                break;
            }
        }
        return false;
    }
}