package fly.leetcode.cn.q1047;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testSimple(){
        assertEquals("ca",solution.removeDuplicates("abbaca"));
        assertEquals("ahgnsgog",solution.removeDuplicates("ahgnsgog"));
        assertEquals("",solution.removeDuplicates("ffffff"));
        assertEquals("f",solution.removeDuplicates("fffffff"));
        assertEquals("asa",solution.removeDuplicates("asssaafwwfa"));
    }
}