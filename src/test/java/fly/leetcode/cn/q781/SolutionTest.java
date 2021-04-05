package fly.leetcode.cn.q781;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution  = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[1, 1, 2]$5",
            "[10, 10, 10]$11",
            "[]$0",
            "[1,0,1,0,0]$5",
            "[1,0,1,0,0,1,3,4,5,6,46,36,7,3,7,8,5,3,6,4,3,5,7,4,35,9]$176",
            "[1,0,1,0,0,1,3,4,5,6,36,36,7,3,7,8,5,3,6,4,3,5,7,4,36,9]$93",
    })
    @ParameterizedTest
    void numRabbits(@ConvertWith(IntArrayConverter.class) int[] a, int expect) {
        assertEquals(expect,solution.numRabbits(a));
    }
}