package fly.leetcode.cn.q74;


/**
 * 一开始我自己想的，但是看了官方题解能够使用一次二分查找做，太菜辽
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int col = matrix[0].length;
        int r = matrix.length*col-1;
        while (l<=r){
            int mid = (l+r)>>1;
            int val = matrix[mid/col][mid%col];
            if (val == target || matrix[l/col][l%col] == target || matrix[r/col][r%col] == target){
                return true;
            } else if (val > target){
                r = mid-1;
                l+=1;
            } else {
                l = mid+1;
                r-=1;
            }
        }
        return false;
    }
}
