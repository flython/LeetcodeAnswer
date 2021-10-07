package fly.leetcode.cn.q1482;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@',value = {
            "[1,10,3,10,2]@3@1@3",
            "[1,10,3,10,2]@3@2@-1",
            "[7,7,7,7,12,7,7]@2@3@12",
            "[1,10,2,9,3,8,4,7,5,6]@4@2@9",
            "[62,75,98,63,47,65,51,87,22,27,73,92,76,44,13,90,100,85]@2@7@98"
    })
    @ParameterizedTest
    void minDays(@ConvertWith(IntArrayConverter.class) int[] bloomDay, int m, int k, int expect) {
        int res = solution.minDays(bloomDay, m, k);
        assertEquals(expect,res);
    }
}