package fly.leetcode.cn.q263;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,true",
            "5,true",
            "6,true",
            "8,true",
            "9,true",
            "10,true",
            "12,true",
            "15,true",
            "16,true",
            "18,true",
            "17,false",
    })
    @ParameterizedTest
    void isUgly( int num, boolean expect) {
        assertEquals(expect,solution.isUgly(num));
    }
}