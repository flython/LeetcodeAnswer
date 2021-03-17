package fly.leetcode.lcp.lcp03;

import java.util.BitSet;

/**
 * 1. 先确定一次循环能走到的范围
 * 2. 把所有小于终点的障碍点与终点映射到范围内
 * 3. 实际走一次，遇到终点标记一下，遇到障碍直接退出false
 * 4. 返回标记位
 */
class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int borderX = 0;
        int borderY = 0;
        for (int i = 0, charArrayLength = command.length(); i < charArrayLength; i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                ++borderX;
            } else {
                ++borderY;
            }
        }

        int times;
        BitSet[] map = new BitSet[borderX+1];
        for (int[] obstacle : obstacles) {
            if (obstacle[0] > x || obstacle[1] > y){
                continue;
            }
            times = Math.min(obstacle[0]/borderX,obstacle[1]/borderY);
            int ox = obstacle[0] - times*borderX;
            int oy = obstacle[1] - times*borderY;
            //原点有，肯定撞
            if (ox > borderX || oy > borderY){
                continue;
            }else if (ox==0&&oy==0){
                return false;
            }
            if (map[ox]==null){
                map[ox] = new BitSet();
            }
            map[ox].set(oy);
        }

        //终点
        times = Math.min(x / borderX, y / borderY);
        x=x-times*borderX;
        y=y-times*borderY;

        //别忽略0，0的情况
        if (x>borderX ||  y >borderY){
            return false;
        }

        int posx=0;
        int posy=0;
        boolean achieve = false;
        for (int i = 0, charArrayLength = command.length(); i < charArrayLength; i++) {
            char c = command.charAt(i);
            if (c=='R'){
                posx++;
            } else {
                posy++;
            }
            //撞了
            if (map[posx]!=null && map[posx].get(posy)){
                return false;
            }
            //抵达终点
            if (posx == x && posy == y){
                //有可能之后撞，暂存到终点这个结果
                achieve = true;
            }
        }

        if (x == 0 && y == 0){
            return true;
        }
        return achieve;
    }

}