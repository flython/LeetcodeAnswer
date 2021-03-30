package fly.leetcode.cn.q69;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    SolutionQ solution = new SolutionQ();

    @ValueSource(ints = {
            1262594113,
//            Integer.MAX_VALUE,
    })
    @ParameterizedTest
    void mySqrt(int number) {
        for (int i = number; i >=0; i--) {
            int res = solution.mySqrt(i);
            assertEquals(Double.valueOf(Math.sqrt(i)).intValue(),res,"错误的是"+i);
            if (i % 10000000 == 0){
                System.out.println(i);
            }
        }

    }

    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,Integer.MAX_VALUE})
    @ParameterizedTest
    void mySqrt2(int i) {
        int res = solution.mySqrt(i);
        assertEquals(Double.valueOf(Math.sqrt(i)).intValue(),res,"错误的是"+i);

    }
}