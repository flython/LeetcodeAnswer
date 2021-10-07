package fly.leetcode.cn.q405;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @CsvSource(value = {
            "26,1a",
            "0,0",
            "-1,ffffffff",
    })
    @ParameterizedTest
    void toHex(int num,String expected) {
        assertEquals(expected,solution.toHex(num));
    }
}