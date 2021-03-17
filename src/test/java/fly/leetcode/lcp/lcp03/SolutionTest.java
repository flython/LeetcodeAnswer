package fly.leetcode.lcp.lcp03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    Solution3 s = new Solution3();

    @Test
    void robot() {
        assertEquals(true,s.robot("URR",new int[][]{{5,10},{9,4},{9,7},{6,15},{7,0},{9,6},{10,7},{1,3},{7,5}},1486,743));
        assertEquals(false,s.robot("URR",new int[][]{{5,5},{9,4},{9,7},{6,3},{7,0},{9,5},{10,7},{1,1},{7,5}},1486,743));
        assertEquals(false,s.robot("RRRURRU",new int[][]{{4,2}},3,2));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{4,2}},15,5));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{4,2}},15,6));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{4,2}},14,5));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{4,2}},13,5));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{4,2}},7,2));
        assertEquals(true,s.robot("RRRURRU",new int[][]{{10,4}},7,2));
        assertEquals(false,s.robot("RRRURRU",new int[][]{{6,2}},7,2));
        assertEquals(true,s.robot("URR",new int[][]{},3,2));
        assertEquals(false,s.robot("URR",new int[][]{{2,2}},3,2));
        assertEquals(true,s.robot("URR",new int[][]{{4,2}},3,2));
        assertEquals(true,s.robot("URR",new int[][]{{4,2}},3,2));
        assertEquals(false,s.robot("URR",new int[][]{{1,0},{0,1}},3,2));
    }
}