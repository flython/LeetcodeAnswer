package fly.leetcode.cn.q92;

import java.util.List;

/**
 * 1. 注意left right的大小关系，边界值，1 ≤ m ≤ n ≤ 链表长度。
 * 2. 范围从1开始
 * 原题目说只能遍历一次
 *
 * 额...我拿数组来保存不知道算不算遍历一次
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode[] arr = new ListNode[right-left+1];

        ListNode p = head;
        for (int i = 1; i < left; i++) {
            p = p.next;
        }

        for (int i = 0; i <= right-left ; i++) {
            arr[i] = p;
            p = p.next;
        }

        for (int i = 0; i < arr.length/2; i++) {
            ListNode switcher = arr[arr.length - 1 - i];
            arr[i].val = arr[i].val ^ switcher.val;
            switcher.val = arr[i].val ^ switcher.val;
            arr[i].val = arr[i].val ^ switcher.val;
        }

        return head;
    }
}