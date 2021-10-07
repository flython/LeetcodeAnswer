package fly.leetcode.cn.q35;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '@',value = {
            "[1,3,5,6]@5@2",
            "[1,3,5,6]@2@1",
            "[1,3,5,6]@7@4",
            "[1,3,5,6]@0@0",
    })
    @ParameterizedTest
    void searchInsert(@ConvertWith(IntArrayConverter.class) int[] arr, int target, int expect) {
        assertEquals(expect,solution.searchInsert(arr,target));
    }
}