package fly.leetcode.cn.q154;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$', value = {
            "[8,0,1,4,4,5,6,7]$0",
            "[4,5,6,7,0,1,4]$0",
            "[0,1,4,4,5,6,7]$0",
            "[1,4,4,5,6,7,0]$0",
            "[4,4,4,4,4,4,0,1,4]$0",
            "[-1,0,1,4,4,4,4,4,4]$-1",
            "[4,4,4,4,4,4,5,1,4]$1",
            "[4,4,4,4,4,4,4,4,4]$4",
            "[4]$4",
            "[5,4,4]$4",
            "[4,5,4]$4",
            "[4,4,5]$4",
            "[3,4,4]$3",
            "[4,3,4]$3",
            "[4,4,3]$3",
    })
    @ParameterizedTest
    void findMin(@ConvertWith(IntArrayConverter.class) int[] arr, int expect) {
        assertEquals(expect,solution.findMin(arr));
    }

}