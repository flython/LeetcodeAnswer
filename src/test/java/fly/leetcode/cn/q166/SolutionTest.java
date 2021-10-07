package fly.leetcode.cn.q166;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @CsvSource(value = {
            "-2147483648,1,-2147483648",
            "-1,-2147483648,0.0000000004656612873077392578125",
            "-50,8,-6.25",
            "1,2,0.5",
            "2,1,2",
            "2,3,0.(6)",
            "4,333,0.(012)",
            "1,5,0.2",
            "53463,17,3144.(8823529411764705)",

    })
    @ParameterizedTest
    void fractionToDecimal(int numerator, int denominator, String expected) {
        assertEquals(expected,solution.fractionToDecimal(numerator, denominator));
    }

    Solution solution = new Solution();
}