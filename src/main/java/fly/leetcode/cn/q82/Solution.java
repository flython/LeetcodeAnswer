package fly.leetcode.cn.q82;

import fly.leetcode.support.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 首先使用一种比较简单的方法，采用新增节点的方法
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode holder = new ListNode(-101,null);
        ListNode current  = holder;

        boolean keepThisNode = true;

        while (head != null){
            while (head.next != null && head.val == head.next.val){
                //缩短一个重复节点
                head.next = head.next.next;
                keepThisNode = false;
            }
            if (keepThisNode){
                current.next = head;
                current = current.next;
            } else {
                current.next = null;
            }

            head = head.next;
            keepThisNode=true;
        }

        return holder.next;
    }
}