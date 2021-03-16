package fly.leetcode.cn.q474;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class SolutionTest {

    Solution2 s = new Solution2();

    private static Stream<Arguments> findMaxForm() {
        return Stream.of(
                Arguments.of(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"},90,66,29),
                Arguments.of(new String[]{"1100","100000","011111"},6,6,2),
                Arguments.of(new String[]{"10", "0001", "111001", "1", "0"},5,3,4),
                Arguments.of(new String[]{"10", "0001", "111001", "1", "0"},1,1,2),
                Arguments.of(new String[]{"100", "0001", "111001", "100", "00"},1,1,0),
                Arguments.of(new String[]{"100", "0001", "111001", "100", "00"},100,100,5),
                Arguments.of(new String[]{"100", "0001", "111001", "100", "00"},100,1,2),
                Arguments.of(new String[]{"100", "0001", "111001", "100", "00"},1,100,0),
                Arguments.of(new String[]{"10"},5,3,1),
                Arguments.of(new String[]{"10", "0", "1"},1,1,2)
        );
    }

    @MethodSource
    @ParameterizedTest
    public void findMaxForm(String[] strs, int m, int n, int result) {
        assertEquals(result,s.findMaxForm(strs, m, n));
    }
}