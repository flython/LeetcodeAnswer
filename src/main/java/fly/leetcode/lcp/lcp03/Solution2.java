package fly.leetcode.lcp.lcp03;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

/**
 * 1. 先确定一次循环能走到的范围
 * 2. 把所有小于终点的障碍点与终点映射到范围内
 * 3. 实际走一次，遇到终点标记一下，遇到障碍直接退出false
 * 4. 返回标记位
 * 使用 bitSet记住地图，只遍历两次
 *
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 68.82% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 77.78% 的用户
 */
class Solution2 {

    //使用带偏移的BitSet，可以减少一点内存占用
    static class MapPointer{
        int first = -1;
        BitSet more;

        void set(int i){
            if(first < 0){
                first = i;
                more = new BitSet();
                more.set(0);
            } else {
                more.set(i - first);
            }
        }

        boolean get(int i){
            if (i < first){
                return false;
            }
            return more.get(i-first);
        }
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {

        ArrayList<MapPointer> road = new ArrayList<>(command.length()>>1);

        int posX = 0;
        int posY = 0;

        // 使用BitSet记住地图
        road.add(new MapPointer());
        road.get(0).set(0);
        for (int i = 0, charArrayLength = command.length(); i < charArrayLength; i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                ++posX;
                road.add(new MapPointer());
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