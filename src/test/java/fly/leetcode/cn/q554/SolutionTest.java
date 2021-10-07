package fly.leetcode.cn.q554;

import fly.testutils.converter.IntArrayConverter;
import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@', value = {
           "[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]@2",
            "[[1],[1],[1]]@3",
            "[[10]]@1",
            "[[1]]@1"
    })
    @ParameterizedTest
    void leastBricks(@ConvertWith(IntMatrixConverter.class) int[][] matrix, int expect) {
        List<List<Integer>> collect = Arrays.stream(matrix).map(arr -> Arrays.stream(arr).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        assertEquals(expect,solution.leastBricks(collect));
    }
}