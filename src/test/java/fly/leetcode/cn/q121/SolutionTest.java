package fly.leetcode.cn.q121;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution s =new Solution();

    @Test
    public void maxProfit() {
        assertEquals(5,s.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0,s.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(1,s.maxProfit(new int[]{6,7}));
        assertEquals(0,s.maxProfit(new int[]{6}));
        assertEquals(95,s.maxProfit(new int[]{5,7,6,4,3,98,1,5,7,6,4,3,1,7,1,5,3,6,4,7,1,5,3,6,4}));
        assertEquals(394,s.maxProfit(new int[]{5,7,6,4,39,98,1,5,7,6,4,3,1,7,1,5,3,6,4,7,1,5,3,395,4}));
        assertEquals(394,s.maxProfit(new int[]{5,7,6,4,39,98,10,9,8,6,4,3,2,7,1,5,3,6,4,7,1,5,3,395,4}));
        assertEquals(Integer.MAX_VALUE-4,s.maxProfit(new int[]{5,7,6,4,39,Integer.MAX_VALUE,10,9,8,6,4,3,2,7,1,5,3,6,4,7,1,5,3,395,4}));
        assertEquals(Integer.MAX_VALUE-4,s.maxProfit(new int[]{5,7,6,4,39,Integer.MAX_VALUE,10,9,8,6,4,3,2,7,1,5,3,6,4,7,1,5,3,395,4}));
    }
}