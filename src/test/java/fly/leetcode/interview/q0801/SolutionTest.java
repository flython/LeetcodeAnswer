package fly.leetcode.interview.q0801;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    SolutionQuickly solution = new SolutionQuickly();

    @Test
    public void waysToStep() {
        assertEquals(4,solution.waysToStep(3));
        assertEquals(13,solution.waysToStep(5));
        assertEquals(274,solution.waysToStep(10));
        assertEquals(230552708,solution.waysToStep(50));
        assertEquals(509672692,solution.waysToStep(1000));
        assertEquals(78591238,solution.waysToStep(2000));

    }
}