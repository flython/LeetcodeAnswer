package fly.testutils;

import com.alibaba.fastjson.JSONArray;
import fly.leetcode.support.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
public abstract class ListNoteTest {

    protected ListNode buildForTest(JSONArray input){
        if (input == null || input.isEmpty()){return null;}
        ListNode head = new ListNode(input.getInteger(input.size() - 1), null);
        for (int i = input.size() - 2; i >= 0; i--) {
            head = new ListNode(input.getInteger(i),head);
        }
        return head;
    }

    protected void assertListEqual(ListNode output, JSONArray predict){
        int i = 0;
        while (output!= null){
            assertEquals(predict.getInteger(i++),output.val);
            output = output.next;
        }
        assertEquals(i,predict.size());
    }
}
