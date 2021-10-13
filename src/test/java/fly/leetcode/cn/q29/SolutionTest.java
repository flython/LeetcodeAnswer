package fly.leetcode.cn.q29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void divide() {
        assertEquals(2147483647/-2147483648,new Solution().divide(2147483647,-2147483648));
        assertEquals(2147483647,new Solution().divide(-2147483648,-1));
        assertEquals(2147483647,new Solution().divide(-2147483648,-1));
        assertEquals(10/3,new Solution().divide(10,3));
        assertEquals(2147483647/3,new Solution().divide(2147483647,3));
        assertEquals(2147483647/-2147483647,new Solution().divide(2147483647,-2147483647));
    }


    @Test
    void mtp() {
        System.out.println(-2147483648 / 1);
        System.out.println(solution.mtp(-2147483648,-1));
    }
}