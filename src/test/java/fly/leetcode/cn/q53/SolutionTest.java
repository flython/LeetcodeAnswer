package fly.leetcode.cn.q53;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    Solution solution = new SolutionLoop();

    @Test
    public void testSolution(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(nums);
        assertEquals(6,i);
    }

    @Test
    public void testSolution1(){
        int[] nums = {-2,1,-3,4,-5,1,1,1,1,1,1};
        int i = solution.maxSubArray(nums);
        assertEquals(6,i);
    }


    @Test
    public void testSolution2(){
        int[] nums = {-2,1,-1,-1,4,-1,1,1,-5,4};
        int i = solution.maxSubArray(nums);
        assertEquals(5,i);
    }

    @Test
    public void testSolution4(){
        int[] nums = {1,2};
        int i = solution.maxSubArray(nums);
        assertEquals(3,i);
    }

}