package fly.leetcode.cn.q2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //换种思路，可以用Java给我们提供的工具类来解决问题，虽然逃避了算法，但是在实际开发中，对于java而言，这是一个很高效地解决问题的方法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = node2Str(l1);
        String s2 = node2Str(l2);

        BigInteger decimal1 = new BigInteger(s1);
        BigInteger decimal2 = new BigInteger(s2);

        BigInteger add = decimal1.add(decimal2);

        char[] chars = add.toString().toCharArray();

        ListNode result = new ListNode(0);
        ListNode current = result;
        for (int i = chars.length - 1; i >= 0; i--) {
            current.next = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
            current = current.next;
        }

        return result.next;

    }

    String node2Str(ListNode node){
        StringBuilder str1 = new StringBuilder();
        ListNode current = node;
        while (current != null){
            str1.append(current.val);
            current = current.next;
        }
        return str1.reverse().toString();
    }

    //很简单的解法，但是很菜
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode res = new ListNode(0);
        ListNode current = res;
        int carry = 0;
        while (c1 != null || c2 != null){
            int num1 = c1==null? 0 : c1.val;
            int num2 = c2==null? 0 : c2.val;
            int sum = num1 + num2 + carry;
            carry = sum > 9? 1 : 0;
            sum = sum%10;
            current.next = new ListNode(sum);

            c1 = c1==null?null:c1.next;
            c2 = c2==null?null:c2.next;
            current = current.next;
        }
        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = parseNode(342);
        ListNode l2 = parseNode(456);
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
    }

    public static  ListNode parseNode(int num){
        char[] chars = new StringBuilder().append(num).reverse().toString().toCharArray();
        ListNode result = new ListNode(0);
        ListNode current = result;
        for (char aChar : chars) {
            current.next = new ListNode(Integer.parseInt(String.valueOf(aChar)));
            current = current.next;
        }
        return result.next;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }