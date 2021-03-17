package fly.leetcode.cn.q92;

/**
 * 1. 注意left right的大小关系，边界值，1 ≤ m ≤ n ≤ 链表长度。
 * 2. 范围从1开始
 * 新建对象解法
 */
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode top = head;
        ListNode tmp = top.next;
        // left == 1 时不会移动
        for (int i = 1; i < left; i++) {
            top = top.next;
            tmp = top.next;
        }
        ListNode reverse = null;
        ListNode tail = null;

        for (int i = right - left - 2; i >= 0; i--){
            reverse = new ListNode(tmp.val,reverse);
            if (tail == null){
                tail = reverse;
            }
            if (i == 0){
                top.val = tmp.val;
                if (tail != null){
                    tail = tmp.next;
                }
            }
            tmp = tmp.next;
        }
        return head;
    }
}