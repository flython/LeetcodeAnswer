package fly.leetcode.cn.q82;

import com.alibaba.fastjson.JSONArray;
import fly.leetcode.support.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @CsvSource(delimiter = '$',value = {
            "[1,2,2]$[1]",
            "[1,1,1,2,3]$[2,3]",
            "[1,2,3,3,4,4,5]$[1,2,5]",
            "[1,1,2,2,3,3,4,4,5,5,5]$[]",
            "[1,1,2,2,3,3,4,,5,5,5]$[4]",
            "[]$[]"
    })
    @ParameterizedTest
    void deleteDuplicates(JSONArray input, JSONArray res) {
        ListNode head = input.isEmpty()?null: new ListNode(input.getInteger(input.size() - 1), null);
        for (int i = input.size() - 2; i >= 0; i--) {
            head = new ListNode(input.getInteger(i),head);
        }

        ListNode output = solution.deleteDuplicates(head);

        int i = 0;
        while (output!= null){
            assertEquals(res.getInteger(i++),output.val);
            output = output.next;
        }

        assertEquals(i,res.size());

    }
}