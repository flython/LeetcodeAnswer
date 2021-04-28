package fly.leetcode.cn.q363;

import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@',value = {
            "[[1,0,1],[0,-2,3]]@2@2",
            "[[2,2,-1]]@3@2",
    })
    @ParameterizedTest
    void maxSumSubmatrix(@ConvertWith(IntMatrixConverter.class) int[][] matrix, int k, int expect) {
        assertEquals(expect,solution.maxSumSubmatrix(matrix,k));
    }
}