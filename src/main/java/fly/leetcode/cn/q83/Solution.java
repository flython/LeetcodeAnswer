package fly.leetcode.cn.q83;

import fly.leetcode.support.ListNode;

/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 87.14% 的用户
 * 好像没有更优了...
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null){
            var current = head;
            while(current.next != null){
                if (current.val == current.next.val){
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
        return head;
    }
}