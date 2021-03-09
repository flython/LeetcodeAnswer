package fly.leetcode.cn.q53;

import junit.framework.TestCase;
import org.junit.Test;

public class SolutionTest extends TestCase {

    Solution solution = new Solution();


    @Test
    public void testSolution(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(nums);
        assertEquals(6,i);
    }
}