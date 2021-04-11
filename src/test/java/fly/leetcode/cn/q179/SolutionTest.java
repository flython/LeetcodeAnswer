package fly.leetcode.cn.q179;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@',value = {
            " [3,30,34,5,9] @ 9534330",
            "[10,2] @ 210",
            "[0,0] @ 0",
            "[0,0,0] @ 0",
            "[10] @ 10",
            "[3,30,34,5,9,8947,654688,1354,978,46546,78,91354,7897984,132354] @ 9978913548947789798478654688546546343301354132354",
            "[78979848,79879,79889489,7987] @ 7988948979879798778979848",
    })
    @ParameterizedTest
    void largestNumber(@ConvertWith(IntArrayConverter.class) int[] arr, String expect) {
        assertEquals(expect,solution.largestNumber(arr));
    }
}