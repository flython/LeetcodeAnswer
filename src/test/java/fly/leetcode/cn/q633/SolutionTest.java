package fly.leetcode.cn.q633;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();
    @CsvSource(value = {
            "0,true",
            "3,false",
            "5,true",
            "4,true",
            "2,true",
            "1,true",
    })
    @ParameterizedTest
    void judgeSquareSum(int input,boolean expect) {
        assertEquals(expect,solution.judgeSquareSum(input));
    }
}