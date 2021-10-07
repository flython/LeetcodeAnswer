package fly.leetcode.cn.q7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "-123,-321"
    })
    @ParameterizedTest
    void reverse(int input, int expect) {
        assertEquals(expect,solution.reverse(input));
    }
}