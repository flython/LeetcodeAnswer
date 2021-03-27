package fly.leetcode.cn.q73;

import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]`[[0,0,0,0],[0,4,5,0],[0,3,1,0]]",
            "[[4,1,2,5],[3,4,0,2],[1,3,1,5]]`[[4,1,0,5],[0,0,0,0,],[1,3,0,5]]",
    },delimiter = '`')
    @ParameterizedTest
    void setZeroes(@ConvertWith(IntMatrixConverter.class) int[][] matrix,
                   @ConvertWith(IntMatrixConverter.class) int[][] result) {

        solution.setZeroes(matrix);
        for (int i = 0; i < result.length; i++) {
            assertArrayEquals(matrix[i],result[i],i + " not not equal");
        }
    }
}