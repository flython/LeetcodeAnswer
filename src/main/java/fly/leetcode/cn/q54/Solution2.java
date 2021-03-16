package fly.leetcode.cn.q54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 虽然4ms击败100用户，但是总觉得不太靠谱，尝试换种实现方法吧
 * 这个看起来简单但是写着做了好多重复工作
 */
class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top,left,right,bottom;
        top = left = 0;
        bottom = matrix.length - 1;
        right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>(matrix.length* matrix[0].length);
        byte action = (byte) 1;
        while (true){
            if (action == 1) {
                if (right < left){break;}
                int[] target = matrix[top++];
                for (int i = left; i <= right; i++) {
                    res.add(target[i]);
                }
                action = (byte) 2;
            } else if (action == 2) {
                if (bottom < top){break;}
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                action = (byte) -1;
            } else if (action == -1) {
                if (right < left){break;}
                int[] target = matrix[bottom--];
                for (int i = right; i >= left; i--) {
                    res.add(target[i]);
                }
                action = (byte) -2;
            } else if (action == -2) {
                if (bottom < top){break;}
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                action = (byte) 1;
            }
        }
        return res;
    }
}