package fly.leetcode.cn.q155;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    static MinStackElegant stack = new MinStackElegant();


    @CsvSource({
            "push,-2,",
            "push,0,",
            "push,-3,",
            "push,-2,",
            "push,0,",
            "push,-3,",
            "push,-2,",
            "push,0,",
            "push,-3,",
            "push,-3,",
            "push,-3,",
            "min,,-3",
            "pop,,",
            "top,,-3",
            "min,,-3",
            "push,-108,",
            "push,370,",
            "min,,-108",
    })
    @ParameterizedTest
    public void testStack(String opera, Integer operand, Integer result){
        switch (opera){
            case "push":
                stack.push(operand);
                break;
            case "pop":
                stack.pop();
                break;
            case "top":
                assertEquals(result,stack.top());
                break;
            case "min":
                assertEquals(result,stack.getMin());
                break;
            default:
        }
    }
}