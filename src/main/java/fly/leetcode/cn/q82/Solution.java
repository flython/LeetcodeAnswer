package fly.leetcode.cn.q82;

import fly.leetcode.support.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 排序性是一个重要的点
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        boolean deleteCurrent = false;
        ListNode current = head;
        ListNode pre = head;

        do {
            if (current.next.val == current.val){
                //删除当前的下一节点，并标记当前节点也需要删除
                current.next = current.next.next;
                deleteCurrent = true;
            } else {
                ListNode next = current.next;
                if (deleteCurrent){
                    if (pre == current){
                        pre = next;
                    } else {
                        pre.next = next;
                    }
                }
                pre = current;
                current = next;
            }
        } while (current.next != null);

        return head;
    }
}