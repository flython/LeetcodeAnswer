package fly.leetcode.cn.q371;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

   Solution solution = new Solution();

    @CsvSource(value = {
            "1,2,3",
            "2,3,5",
            "-2,3,1",
            "-3,2,-1",
            "-1000,1000,0",
            "-1000,10,-990",
    })
    @ParameterizedTest
    void getSum(int a,int b, int sum) {
        assertEquals(solution.getSum(a,b),sum);
    }
}