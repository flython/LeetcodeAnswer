package fly.leetcode.cn.q91;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "2611055971756562,4",
//            "12,2",
//            "226,3",
//            "11106,2",
//            "0,0",
//            "00,0",
//            "168147826402515,0",
//            "168147826102515,32",
//            "27,1",
    })
    @ParameterizedTest
    void testNumDecodings(String input,int expect) {
        int i = solution.numDecodings(input);
        assertEquals(expect,i);
    }
}