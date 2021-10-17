package fly.leetcode.cn.q518;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[1, 2, 5]$5$4",
            "[1, 2, 3]$5$5",
            "[10]$10$1",
            "[10]$11$0",
    })
    @ParameterizedTest
    void change(@ConvertWith(IntArrayConverter.class) int[] coins, int amount, int exp) {
        assertEquals(exp,new Solution().change(amount,coins));
    }
}