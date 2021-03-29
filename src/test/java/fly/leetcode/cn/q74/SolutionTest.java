package fly.leetcode.cn.q74;

import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$3$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$13$false",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$1$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$5$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$7$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$10$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$11$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$16$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$20$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$23$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$30$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$34$true",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]$60$true",
            "[[-105]]$-105$true",
            "[[-105]]$-106$false",
    })
    @ParameterizedTest
    void searchMatrix(@ConvertWith(IntMatrixConverter.class) int[][] matrix, int target, boolean res) {
        assertEquals(res,solution.searchMatrix(matrix, target));
    }
}