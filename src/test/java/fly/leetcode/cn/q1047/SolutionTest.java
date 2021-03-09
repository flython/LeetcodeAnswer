package fly.leetcode.cn.q1047;

import junit.framework.TestCase;
import org.junit.Test;

public class SolutionTest extends TestCase {

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