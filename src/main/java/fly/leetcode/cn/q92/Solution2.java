package fly.leetcode.cn.q92;

/**
 * 网上找的，报错了
 */
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int len = 0;
        ListNode node1 = null;
        ListNode pre = null;
        ListNode last = null;
        while(node1!=null){
            len++;
            pre = len==left-1?node1:pre;   //如果在len++的过程中，找到了from前一个，那就将pre定为此时累加到的这个节点
            last = len==right+1?node1:last;    //同理，如果在len++过程中找到了to后面的一个，就赋值为当前点，否则均为null
            node1 = node1.next;
        }
        if(left>right||left<1||right>len) {
            return head;
        }
        node1 = pre==null?head:pre.next;    //看是否需要换头，如果pre==null的时候，头结点要换了，就是从原头开始换
        ListNode node2 = node1.next;
        node1.next = last;       //将原来的头连至to+1
        ListNode next = null;
        while(node2!=last) {     //下一位依次指向前
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(pre!=null) {          //如果pre存在的时候，接到pre（left-1）后面
            pre.next = node1;
            return head;
        }
        return node1;     //否则不
    }
}