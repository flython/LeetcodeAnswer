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
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return lr(matrix).collect(Collectors.toList());
    }

    Stream<Integer> lr(int[][] matrix){
        Stream<Integer> res = Arrays.stream(matrix[0]).boxed();
        if (matrix.length > 1){
            var subMattix = new int[matrix.length-1][];
            System.arraycopy(matrix,1,subMattix,0,matrix.length-1);
            res = Stream.concat(res,tb(subMattix));
        }
        return res;
    }
    Stream<Integer> tb(int[][] matrix){
        List<Integer> list = new ArrayList<>(matrix.length);
        int lastPos = matrix[0].length-1;
        for (int i = 0; i < matrix.length; i++) {
            list.add(matrix[i][lastPos]);
            if (lastPos != 0){
                matrix[i] = Arrays.copyOf(matrix[i],lastPos);
            }
        }
        Stream<Integer> res = list.stream();
        if (lastPos != 0){
            res = Stream.concat(res,rl(matrix));
        }
        return res;
    }
    Stream<Integer> rl(int[][] matrix){
        int bottomPos = matrix.length - 1;
        List<Integer> collect = Arrays.stream(matrix[bottomPos]).boxed().collect(Collectors.toList());
        Collections.reverse(collect);
        Stream<Integer> res = collect.stream();
        if (bottomPos != 0){
            var subMattix = new int[matrix.length-1][];
            System.arraycopy(matrix,0,subMattix,0,bottomPos);
            res = Stream.concat(res,bt(subMattix));
        }
        return res;
    }
    Stream<Integer> bt(int[][] matrix){
        List<Integer> list = new ArrayList<>(matrix.length);
        int lastPos = matrix[0].length-1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            list.add(matrix[i][0]);
            if (lastPos != 0){
                int[] subArr = new int[lastPos];
                System.arraycopy(matrix[i],1,subArr,0,lastPos);
                matrix[i] = subArr;
            }
        }
        Stream<Integer> res = list.stream();
        if (lastPos != 0){
            res = Stream.concat(res,lr(matrix));
        }
        return res;
    }
}