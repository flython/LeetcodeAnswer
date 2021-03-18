package fly.leetcode.cn.q92;

/**
 * 1 2 3 4 5
 * 2,4
 * 1. 注意left right的大小关系，边界值，1 ≤ m ≤ n ≤ 链表长度。
 * 2. 范围从1开始
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode protect = head;
        ListNode tmp;
        ListNode reverse = null;
        ListNode tail = null;

        //protect 一开始已经等于第一个
        for (int i = 2; i < left; i++) {
            protect = protect.next;
        }

        //指向第一个翻转
        tmp = protect.next;

        // 2 - 4 有三个点
        for (int i = left; i <= right; i++) {
            if (reverse == null){
                tail = new ListNode(tmp.val,null);
                reverse = tail;
            } else {
                reverse = new ListNode(tmp.val,reverse);
            }
            tmp = tmp.next;
        }

        protect.next = reverse;
        if (tail != null){
            tail.next = tmp;
        }

        if (left == 1){
            return reverse;
        } else {
            return head;
        }

    }
}