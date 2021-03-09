package fly.leetcode.cn.q365;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0 || z == x || z == y)return true;
        if (z > x + y)return false;
        if (y < x){int t = y; y = x; x = t;}
        if (z > y) z = z - x;
        if (x == 0) return false;
        int n = y/x;
        int yu = y % x;
        int des = (n+1) * x  - y;
        if (des != 0){
            int manyCount = x / des;
            for (int j = 1; j < manyCount; j++) {
                int newy = y-j*des;
                for (int i = 0; i <= n; i++) {
                    if (newy - i * x == z) return true;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (y - i * x == z) return true;
        }
        if (yu + x == z || yu + y == z) return true;
        if (x - des == z || y - des ==z || x+y - des == z)return true;
        return false;
    }
}
