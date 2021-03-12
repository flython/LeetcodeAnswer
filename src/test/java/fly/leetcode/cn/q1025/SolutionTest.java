package fly.leetcode.cn.q1025;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution2();
    Solution solution3 = new Solution3();

    @Test
    public void divisorGame() {
        assertTrue(solution.divisorGame(2));
        assertFalse(solution.divisorGame(3));
        assertTrue(solution.divisorGame(4));
        assertFalse(solution.divisorGame(5));
        assertTrue(solution.divisorGame(6));//1,2,3
    }

    @Test
    public void cheat(){
        for (int i = 1; i <= 1000; i++) {
            assertEquals(solution.divisorGame(i),solution3.divisorGame(i));
        }

    }
}