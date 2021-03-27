package fly.leetcode.cn.q204;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource({
            "10,4",
            "0,0",
            "1,0",
            "101,25",
            "2,0",
            "135,32",
    })
    @ParameterizedTest
    void countPrimes(int n, int predict) {
        assertEquals(predict,solution.countPrimes(n));
    }
}