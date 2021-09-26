package fly.leetcode.cn.q213;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[1]$1",
            "[1,2]$2",
            "[2,3,2]$3",
            "[1,2,3,4]$6",
            "[2,3,2,5,7,3,7,2,4]$21",
            "[2,3,2,5,7,3,7,2,4,5,3,6]$28",
            "[2,3,2,5,7,3,7,2,4,5,3,6,7,2,3,2,5,7,3,7,2,4,5,3,6,7,2,3,2,5,7,3,7,2,4,5,3,6,7,2,3,2,5,7,3,7,2,4,5,3,6,7]$124",
    })
    @ParameterizedTest
    void rob(@ConvertWith(IntArrayConverter.class) int[] input, int expect) {
        assertEquals(expect,solution.rob(input));
    }
}