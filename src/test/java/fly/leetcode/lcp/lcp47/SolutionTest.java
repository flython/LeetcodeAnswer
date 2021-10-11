package fly.leetcode.lcp.lcp47;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[2,2,3]$2$2",
            "[3,3]$3$0",
            "[4,3,2,2]$6$2",
            "[4,3,2,2,1,2,2]$2$14",
    })
    @ParameterizedTest
    void securityCheck(@ConvertWith(IntArrayConverter.class) int[] capacities , int k , int expected) {
        assertEquals(expected,solution.securityCheck(capacities, k));
    }
}