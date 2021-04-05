package fly.leetcode.cn.q80;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @CsvSource(delimiter = '$',value = {
            "[0]$[0]",
            "[1,1,1,2,2,3]$[1,1,2,2,3]",
            "[0,0,1,1,1,1,2,3,3]$[0,0,1,1,2,3,3]",
            "[0,0,0,0,0,0,0,0,0]$[0,0]",
            "[]$[]",
            "[1,1,1,2,2,3,3,3,3,4,5,6,7,7,7,7,7,7,7,8,8,8,8,9,10,11,12,15,15,15,15,16]$[1,1,2,2,3,3,4,5,6,7,7,8,8,9,10,11,12,15,15,16]",
    })
    @ParameterizedTest
    void removeDuplicates(@ConvertWith(IntArrayConverter.class) int[] nums, @ConvertWith(IntArrayConverter.class)int[] expect) {
        int len = solution.removeDuplicates(nums);
        assertEquals(expect.length,len);
        assertArrayEquals(expect, Arrays.copyOf(nums,len));
    }
}