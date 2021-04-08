package fly.leetcode.cn.q153;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[3,4,5,1,2]$1",
            "[4,5,6,7,0,1,2]$0",
            "[11,13,15,17]$11",
            "[1]$1",
    })
    @ParameterizedTest
    void findMin(@ConvertWith(IntArrayConverter.class) int[] input, int expect) {
        assertEquals(expect,solution.findMin(input));
    }
}