package fly.leetcode.cn.q62;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(value = {
            "7,3,28"
    })
    @ParameterizedTest
    void uniquePaths(int m,int n, int exp) {
        assertEquals(exp,new Solution().uniquePaths(m, n));
    }
}