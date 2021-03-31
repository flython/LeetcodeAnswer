package fly.leetcode.cn.q90;

import fly.testutils.ArrayCompareTest;
import fly.testutils.converter.IntArrayConverter;
import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends ArrayCompareTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[1,2,2]$[[],[1],[1,2],[1,2,2],[2],[2,2]]",
            "[0]$[[],[0]]",
            "[1,2,1,2,3]$[[],[1, 2, 1],[2, 3],[1],[1, 2, 1, 2, 3],[2],[1, 2, 1, 2],[3],[1, 2],[1, 2, 1, 3],[1, 2, 2, 3],[1, 2, 3],[2, 2],[1, 1, 3],[1, 2, 2],[1, 3],[1, 1],[2, 2, 3]]",
    })
    @ParameterizedTest
    void subsetsWithDup(@ConvertWith(IntArrayConverter.class) int[] input, @ConvertWith(IntMatrixConverter.class) int[][] expect) {
        List<List<Integer>> output = solution.subsetsWithDup(input);
        assertMatrixEqual(expect,output);
    }
}