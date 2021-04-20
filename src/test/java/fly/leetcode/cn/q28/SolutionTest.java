package fly.leetcode.cn.q28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    @CsvSource(value = {
            "hello,ll,2",
            "aaaaa,bba,-1",
            "aaa,aaaaa,-1",
            "aaa,aaa,0",
            "mississippi,issip,4",
            "mississippi,issi,1",
            "mississippi,issipi,-1",
            "'','',0",
            "abc,'',0",
    })
    @ParameterizedTest
    void strStr(String h,String n, int expect) {
        assertEquals(expect,solution.strStr(h,n));
    }
}