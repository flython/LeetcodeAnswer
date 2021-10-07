package fly.leetcode.cn.q13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "III,3",
            "IV,4",
            "IX,9",
            "LVIII,58",
            "MCMXCIV,1994"
    })
    @ParameterizedTest
    void romanToInt(String roma, int expect) {
        assertEquals(expect,solution.romanToInt(roma));
    }
}