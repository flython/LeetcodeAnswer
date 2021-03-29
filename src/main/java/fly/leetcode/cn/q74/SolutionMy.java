package fly.leetcode.cn.q74;


/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 99.41% 的用户
 * 一开始我自己想的，但是看了官方题解能够使用一次二分查找做，太菜辽
 */
class SolutionMy {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] possible;
        int r = matrix[0].length-1;
        int l,mid;
        for (int i = 0; i < matrix.length; i++) {
            possible = matrix[i];
            if (possible[0] == target || possible[r] == target){
                return true;
            } else if (possible[0] < target && possible[r] > target){
                l = 0;
                //这里判断lr大小关系且不相邻
                while (l+1<r){
                    mid = (l+r)>>1;
                    if (possible[mid] == target){
                        return true;
                    } else if (possible[mid] > target){
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
                break;
            }
        }
        return false;
    }
}
