package fly.leetcode.cn.q131;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @CsvSource({
            "fff",
            "aabcb",
            "a",
            "abahsbahasbshfbs",
            "aab",

    })
    @ParameterizedTest
    void partition(String s) {
        List<List<String>> partition = solution.partition(s);
        for (List<String> strings : partition) {
            System.out.printf("%s,", strings);
        }
    }

    Solution solution = new Solution();
}