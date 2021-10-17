package tmp;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {

    @CsvSource(delimiter = '$',value = {
            "[-3,-2,-1,-5]$7",
           "[3,1]$2",
           "[3,2,1,5]$6",
            "[2,2,2]$7",
            "[-8,2,2,2]$7",
    })
    @ParameterizedTest
    void countMaxOrSubsets(@ConvertWith(IntArrayConverter.class) int[] nums, int exp) {
        int count = new Solution2().countMaxOrSubsets(nums);
        assertEquals(exp,count);
    }
}