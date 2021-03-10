package fly.leetcode.cn.q224;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest{

    Solution solution = new Solution2();

    @Test
    public void calculate() {
        assertEquals(2,solution.calculate("1 + 1"));
        assertEquals(3,solution.calculate(" 2-1 + 2 "));
        assertEquals(1,solution.calculate(" 2+1 - 2 "));
        assertEquals(23,solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(65,solution.calculate("65"));
        assertEquals(-3,solution.calculate("-3"));
        assertEquals(-3,solution.calculate("-2-1"));
        assertEquals(-3,solution.calculate("  -2-1"));
        assertEquals(-3,solution.calculate("  -2+(-1)"));
        assertEquals(-6,solution.calculate("  -2+(-3-1)"));
        assertEquals(11,solution.calculate("(7)-(0)+(4)"));
    }
}