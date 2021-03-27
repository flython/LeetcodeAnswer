package fly.leetcode.cn.q331;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution2 s = new Solution2();

    @Test
    public void isValidSerialization() {
        assertEquals(true,s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertEquals(false,s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,#,6,#"));
        assertEquals(true,s.isValidSerialization("9,3,4,#,6,5,#,4,#,#,#,1,#,#,2,#,6,#,#"));
        assertEquals(false,s.isValidSerialization("1,#"));
        assertEquals(false,s.isValidSerialization("9,#,#,1"));
        assertEquals(false,s.isValidSerialization(""));
        assertEquals(false,s.isValidSerialization("1"));
        assertEquals(true,s.isValidSerialization("#"));
        assertEquals(false,s.isValidSerialization("1,#,#,#,#"));
        assertEquals(false,s.isValidSerialization("#,#,#,#,#,#,#"));
        assertEquals(false,s.isValidSerialization("1,2,3,4,5,6,7"));
        assertEquals(false,s.isValidSerialization("1,#,2,#,1,#,2,#"));
        assertEquals(false,s.isValidSerialization("#,2,#,1,#,2,#,1"));
    }
}