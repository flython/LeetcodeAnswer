package fly.leetcode.cn.q371;

class Solution {
    public int getSum(int a, int b) {
//        return a==0? b: getSum((a&b)<<1,a^b);
        while(a!=0){
            //按位与得到进位
            int carry = a&b;
            //按位异或得到每一位的和
            int noCarrySum = a ^ b;
            a = carry << 1;
            b = noCarrySum;
        }
        return b;
    }
}
