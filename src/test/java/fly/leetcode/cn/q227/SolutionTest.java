package fly.leetcode.cn.q227;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void calculateMore() {
        assertEquals(-3,solution.calculate("-3"));
        assertEquals(-1,solution.calculate("-3/3"));
        assertEquals(-24,solution.calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    @Test
    public void calculate1() {
        assertEquals(7,solution.calculate("3+2*2"));
    }

    @Test
    public void calculate2() {
        assertEquals(1,solution.calculate(" 3/2 "));
    }

    @Test
    public void calculate3() {
        assertEquals(5,solution.calculate(" 3+5 / 2 "));
    }
}