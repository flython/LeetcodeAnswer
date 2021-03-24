package fly.leetcode.cn.q456;

import fly.test.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
//            "[1, 2, 3, 4]$false",
//            "[3, 1, 4, 2]$true",
//            "[-1, 3, 2, 0]$true",
//            "[1,2,3,4,5,6,7,8,9,10]$false",
//            "[10,2,3,4,5,6,7,8,9,10]$false",
//            "[10,21,36,4,5,6,7,8,9,10]$false",
//            "[10,21,36,14,5,6,7,8,9,10]$true",
//            "[-10,21,36,14,5,6,7,8,9,10]$true",
//            "[-10,21,36,-14,5,6,7,8,9,10]$true",
//            "[-10,21,36,-4,5,6,7,8,9,10]$true",
            "[1,4,0,-1,-2,-3,-1,-2]$true",
    })
    @ParameterizedTest
    void find132pattern(@ConvertWith(IntArrayConverter.class) int[] nums,
                        boolean res) {
        assertEquals(res,solution.find132pattern(nums));
    }
}