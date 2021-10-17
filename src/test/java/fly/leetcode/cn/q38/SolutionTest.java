package fly.leetcode.cn.q38;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countAndSay() {
        Solution solution = new Solution();
        String[] strings = new String[30];
        for (int i = 1; i <= 30; i++) {
            strings[i-1] = solution.countAndSay(i);
        }
        System.out.println(Arrays.stream(strings).map(s -> String.format("\"%s\"", s)).collect(Collectors.joining(",")).toString());
    }
}