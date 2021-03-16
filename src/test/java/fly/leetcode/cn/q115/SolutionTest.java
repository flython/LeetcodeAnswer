package fly.leetcode.cn.q115;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();
    @CsvSource({
            "rabbbit,rabbit,3",
            "rabbbit,bit,3",
            "rabbbit,bik,0",
            "rabbbit,abt,3",
            "babgbag,bag,5",
            "babgbag,bag,5",
            "'','',1",
            "aba,'',1",
            "aaaaa,aaaa,5",
            "aaaaa,a,5",
            "jasogijasoidhjliashulsiligdjsalgjohwglsdakgldasgj,ad,14"
            })
    @ParameterizedTest
    void numDistinct(String s,String t, Integer res) {
        assertEquals(res,solution.numDistinct(s, t));
    }
}