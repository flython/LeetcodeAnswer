package fly.leetcode.cn.q63;

import fly.testutils.converter.IntMatrixConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[[0,0,0],[0,1,0],[0,0,0]]$2"
    })
    @ParameterizedTest
    void uniquePathsWithObstacles(@ConvertWith(IntMatrixConverter.class) int[][] obstacleGrid,int exp) {
        assertEquals(exp,new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}