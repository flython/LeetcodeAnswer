package fly.leetcode.cn.q1006;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @CsvSource({
            "4,7",
            "10,12",
            "1,1",
            "2,2",
            "3,6",
    })
    @ParameterizedTest
    void clumsy(int input,int expect) {
        assertEquals(expect,solution.clumsy(input));
    }
}