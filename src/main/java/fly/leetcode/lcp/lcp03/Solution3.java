package fly.leetcode.lcp.lcp03;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;


class Solution3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {

        ArrayList<BitSet> road = new ArrayList<>();

        int posX = 0;
        int posY = 0;

        // 使用BitSet记住地图
        road.add(new BitSet());
        road.get(0).set(0);
        for (int i = 0, charArrayLength = command.length(); i < charArrayLength; i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                ++posX;
                road.add(new BitSet(posY+1));
            } else {
                ++posY;
            }
            road.get(posX).set(posY);
        }

        int times;
        // 处理阻碍点
        for (int[] obstacle : obstacles) {
            // 排除大范围终点外的点
            if (obstacle[0] > x || obstacle[1] > y){
                continue;
            }
            times = Math.min(obstacle[0]/posX,obstacle[1]/posY);
            int ox = obstacle[0] - times*posX;
            int oy = obstacle[1] - times*posY;

            //计算后在区块外
            if (ox > posX || oy > posY){
                continue;
            }else if (ox==0&&oy==0){
                //过程中原点有，路线上肯定撞
                return false;
            } else if (road.get(ox).get(oy)){
                //查到bitmap中有，撞了
                return false;
            }
        }

        //处理终点
        times = Math.min(x/posX, y/posY);
        x=x-times*posX;
        y=y-times*posY;
        //排除终点落在区块外
        if (x>posX || y >posY){
            return false;
        }
        //判断终点是否在路上
        return road.get(x).get(y);
    }

}