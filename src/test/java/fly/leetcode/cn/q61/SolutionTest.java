package fly.leetcode.cn.q61;

import com.alibaba.fastjson.JSONArray;
import fly.leetcode.support.ListNode;
import fly.testutils.ListNoteTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest extends ListNoteTest {
    @CsvSource(delimiter = '$',value = {
            "[1,2]$1$[2,1]",
            "[1,2]$2$[1,2]",
            "[1,2,3,4,5]$2$[4,5,1,2,3]",
            "[1,2,3,4,5]$7$[4,5,1,2,3]",
            "[0,1,2]$4$[2,0,1]",
            "[0,1,2]$7$[2,0,1]",
            "[0,1,2]$0$[0,1,2]",
            "[0]$0$[0]",
            "[]$0$[]",
            "null$0$[]",
    })
    @ParameterizedTest
    void rotateRight(JSONArray input, int k, JSONArray predict) {
        ListNode head = buildForTest(input);
        ListNode output = solution.rotateRight(head, k);
        assertListEqual(output,predict);
    }


    Solution solution =  new Solution();
}