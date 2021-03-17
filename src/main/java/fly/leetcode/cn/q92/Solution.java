package fly.leetcode.cn.q92;

/**
 * 1. 注意left right的大小关系，边界值，1 ≤ m ≤ n ≤ 链表长度。
 * 2. 范围从1开始
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode top = head;
        ListNode tmp = top.next;
        // left == 1 时不会移动
        for (int i = 1; i < left; i++) {
            top = top.next;
            tmp = top.next;
        }

        for (int i = right - left - 2; i >= 0; i--) {
            if (i == 0){
                //由于不能翻转第一个Node，所以相互赋值
                var tmpVal = tmp.next.val;
                tmp.next.val = top.val;
                top.val = tmpVal;
                break;
            }
            var cur = tmp;
            tmp = tmp.next;
            var next = tmp.next;
        }
        top.next = tmp;
        return head;
    }
}