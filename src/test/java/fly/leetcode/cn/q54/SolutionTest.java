package fly.leetcode.cn.q54;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution2 s = new Solution2();

    @Test
    public void spiralOrder() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        check(s.spiralOrder(matrix),1,2,3,6,9,8,7,4,5);
//        check(s.spiralOrder(new int[][]{{1,2,3,4,},{5,6,7,8},{9,10,11,12}}),
//                1,2,3,4,8,12,11,10,9,5,6,7);
        check(s.spiralOrder(new int[][]{{1,2,3,4,},{5,6,7,8},{9,10,11,12},{13,14,15,16}}),
                1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
        check(s.spiralOrder(new int[][]{{1,2,3,4}}), 1,2,3,4);
        check(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8}}), 1,2,3,4,8,7,6,5);
        check(s.spiralOrder(new int[][]{{1},{5},{6}}), 1,5,6);
        check(s.spiralOrder(new int[][]{{1}}), 1);

    }

    void check(List<Integer> list, int... ints){
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            assertTrue("index:"+i,integer.equals(ints[i]));
        }
    }


}