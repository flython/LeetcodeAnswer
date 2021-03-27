package fly.leetcode.cn.q150;

import fly.testutils.converter.StringArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "[\"2\",\"1\",\"+\",\"3\",\"*\"]`9",
            "[\"4\",\"13\",\"5\",\"/\",\"+\"]`6",
            "[\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]`22",
    },delimiter = '`')
    @ParameterizedTest
    void evalRPN(@ConvertWith(StringArrayConverter.class) String[] tokens, int result) {
        assertEquals(result,solution.evalRPN(tokens));
    }
}