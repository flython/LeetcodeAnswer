package fly.leetcode.cn.q33;

import fly.testutils.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[1,3]$2$-1",
            "[4,5,6,7,0,1,2]$0$4",
            "[4,5,6,7,0,1,2]$3$-1",
            "[1]$0$-1",
    })
    @ParameterizedTest
    void search(@ConvertWith(IntArrayConverter.class) int [] arr, int target,int expect) {
        assertEquals(expect,solution.search(arr,target));
    }


    @MethodSource
    @ParameterizedTest
    void searchRandom(@ConvertWith(IntArrayConverter.class) int [] arr, int target,int expect) {
        assertEquals(expect,solution.search(arr,target));
    }

    /**
     * 写一个自动生成测试参数，未完成
     * @return
     */
    public static Stream<Arguments> searchRandom(){
        int count = 10;
        return IntStream.range(0,count).mapToObj(i->{
            int arrSize = 5000;
            HashSet<Integer> set = new HashSet<>();
            Random random = new Random();
            int target = random.nextInt(20000)-10000;
            boolean arrHasTarget = random.nextBoolean();
            while (set.size() < arrSize){
                set.add(random.nextInt(20000)-10000);
            }
            if (arrHasTarget && !set.contains(target)){
                set.add(target);
            } else if (!arrHasTarget && set.contains(target)){
                set.remove(target);
                set.add(random.nextInt(20000)-10000);
            }
            int[] arr = set.stream().sorted().mapToInt(Integer::intValue).toArray();
            return Arguments.of();
        });
    }
}