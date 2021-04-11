package fly.leetcode.cn.q264;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource({
            "10,12",
            "1,1",
    })
    @ParameterizedTest
    void nthUglyNumber(int input, int expect) {
        assertEquals(expect,solution.nthUglyNumber(input));
    }
}