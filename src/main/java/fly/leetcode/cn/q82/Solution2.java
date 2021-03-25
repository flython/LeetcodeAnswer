package fly.leetcode.cn.q82;

import fly.leetcode.support.ListNode;

/**
 * 这个方法内存跟速度都不优秀，采用重新连接链的方式
 * 从q83的思路开始新出发
 */
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null){
            boolean deleteCurrent = false;
            var current = head;
            while(current.next != null){
                if (current.val == current.next.val){
                    current.next = current.next.next;
                    deleteCurrent = true;
                } else {
                    if (deleteCurrent){
                        //需要删除当前，直接用下一个代替当前
                        current.val = current.next.val;
                        current.next = current.next.next;
                    } else {
                        //直接跳到下一个
                        current = current.next;
                    }
                }
            }
        }
        return head;
    }
}