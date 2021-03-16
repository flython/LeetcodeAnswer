package fly.leetcode.cn.q59;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void generateMatrix() {
        int[][] matrix = solution.generateMatrix(10);
    }

    @Test
    void  play(){
        StringBuilder sb2 = new StringBuilder();
        sb2.append("public static int[][][] arr = {");
        for (int i = 1; i <= 30; i++) {
            StringBuilder reduce = Arrays.stream(solution.generateMatrix(i))
                    .map(ints -> Arrays.toString(ints).replaceAll("\\[", "{").replaceAll("\\]", "}"))
                    .reduce(new StringBuilder().append("{"), (sb, s) -> sb.append(s).append(','), (a, b) -> a);
            reduce.deleteCharAt(reduce.length()-1);
            reduce.append("},");
            sb2.append(reduce);
//            System.out.println(reduce);
        }
        sb2.append("}");
        System.out.println(sb2);
    }
}