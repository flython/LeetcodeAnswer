package fly.leetcode.cn.q282;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addOperators() {
        List<String> strings = new Solution().addOperators("9999999999", 1409865409);
        System.out.println(strings.stream().collect(Collectors.joining(",")));
    }

    @Test
    void test2() {
        System.out.println(new Solution.Cal().calculate("99999*99999"));
    }
}