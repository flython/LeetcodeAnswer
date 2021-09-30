package fly.leetcode.cn.q223;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(value = {
            "-2,-2,2,2,2,2,3,3,17",
            "-2,-2,2,2,-1,4,1,6,20",
            "-2,-2,2,2,-4,3,-3,4,17",
            "-2,-2,2,2,3,3,4,4,17",
            "-3,0,3,4,0,-1,9,2,45",
            "-2,-2,2,2,-2,-2,2,2,16",
            "0,0,0,0,-1,-1,1,1,4",
            "-2,-2,2,2,-1,-1,1,1,16",
    })
    @ParameterizedTest
    void computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2,int area) {
        assertEquals(area,solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}