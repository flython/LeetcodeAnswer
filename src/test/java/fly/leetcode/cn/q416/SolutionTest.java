package fly.leetcode.cn.q416;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[1,5,11,5]$true"
    })
    @ParameterizedTest
    void canPartition(@ConvertWith(IntArrayConverter.class) int[] arr, boolean exp) {
        assertEquals(exp,new Solution().canPartition(arr));
    }
}