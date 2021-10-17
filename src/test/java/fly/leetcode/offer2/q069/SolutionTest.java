package fly.leetcode.offer2.q069;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource(delimiter = '$',value = {
            "[3,5,3,2,0]$1",
            "[13,25,38,55,58,75,85,88,100,94,88,82,60,58,48,43,40,35,17,2]$8",
            "[24,69,70,71,72,73,74,100,99,79,78,67,36,26,19]$7",
            "[1,3,5,4,2]$2",
            "[0,1,0]$1",
            "[3,4,5,1]$2"

    })
    @ParameterizedTest
    void peakIndexInMountainArray(@ConvertWith(IntArrayConverter.class) int[] arr, int exp) {
        assertEquals(exp,new Solution().peakIndexInMountainArray(arr));
    }
}