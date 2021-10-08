package fly.leetcode.cn.q187;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void findRepeatedDnaSequences() {
        List<String> resp = solution.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(resp);
    }
}