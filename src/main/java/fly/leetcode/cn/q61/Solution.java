package fly.leetcode.cn.q61;

import fly.leetcode.support.ListNode;

/**
 *  k 有可能比head的长度大，所以要判断长度
 *  注意head 长度1 和head为空的情况
 *
 *  思路：
 *      1. 首先要做特殊输入判断，head为空，k=0不用移动的情况
 *      2. 采用先后出发的两个快慢指针（我就这么叫了），先让快指针移动k步，此时慢指针再出发。待快指针移到末尾处，慢指针指向位置则为新的末尾
 *      3. 随后只需要从慢指针处断开，使快指针（此时在最后一个）的next冲向原来的头
 *      4. 注意需要处理k大于等于链表长度的情况，此时只需要移动 k 与 长度的余值
 *
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null){return head;}
        ListNode faster = head;
        ListNode slower = head;
        int len = 0;

        while (len++ != k){
            faster = faster.next;
            //提前达到末尾，证明k比长度大
            if (faster == null){
                k = k % len;
                //刚好不需要移动的情况
                if (k == 0){
                    return head;
                }
                //使快指针重新出发一遍
                faster = head;
                for (int i = 0; i < k; i++) {
                    faster = faster.next;
                }
                break;
            }
        }

        //遍历到指向最后节点，此时slower指向的是新的末尾
        while (faster.next != null){
            faster = faster.next;
            slower = slower.next;
        }
        // 把slower变成末尾，把slower.next变成头，把原来的头连到faster后
        faster.next = head;
        head = slower.next;
        slower.next = null;
        return head;
    }
}