package fly.leetcode.cn.q69;

//7*7 = 49
//8*8 = 64

/**
 * TODO: 回家再研究 超快开根
 * https://blog.csdn.net/u012966194/article/details/54632635
 */
class SolutionQ {
    public int mySqrt(int x) {
        if (x < 2){return x ;}

        float xhalf = 0.5f * x;
        float dx = x;
        int lx = Float.floatToRawIntBits(dx);
        lx = 0x5f3759df - (lx>>1);
        dx = Float.intBitsToFloat(lx);
        dx = dx * (1.5f - xhalf * dx * dx);
        float baseRes = 0.99975f/dx;
        int res = (int)(baseRes);
        //这个移动不可取，浪费时间

        while (true){
            if (res*res == x){
                return res;
            }else if (res*res > x){
                res--;
            }else{
                long lRes = res + 1L;
                if (lRes*lRes > x){
                    return res;
                } else {
                    res++;
                }
            }
        }
    }
}