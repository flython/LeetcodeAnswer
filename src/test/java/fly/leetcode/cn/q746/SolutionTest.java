package fly.leetcode.cn.q746;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[10, 15, 20]$15",
            "[1, 100, 1, 1, 1, 100, 1, 1, 100, 1]$6",
    })
    @ParameterizedTest
    void minCostClimbingStairs(@ConvertWith(IntArrayConverter.class) int[] cost, int expected) {
        assertEquals(expected,new Solution().minCostClimbingStairs(cost));
    }
}