package fly.leetcode.interview.q1721;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[0,1,0,2,1,0,1,3,2,1,2,1]$6",
            "[0,1,0,2,5,0,1,3,2,1,2,1]$7",
            "[0,1]$0",
            "[0]$0",
            "[0,1,2]$0",
            "[2,1,2]$1",
            "[10,2,2,10]$16",
            "[10,2,2,10,1,2,10]$33",
            "[10,2,2,10,1,2,11]$33",
            "[10,2,2,11,1,2,11]$35",
            "[10,2,12,10,1,2,11]$28",
    })
    @ParameterizedTest
    void trap(@ConvertWith(IntArrayConverter.class) int[] height, int expect) {
        assertEquals(expect,solution.trap(height));
    }
}