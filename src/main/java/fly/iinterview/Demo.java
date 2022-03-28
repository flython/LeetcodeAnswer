package fly.iinterview;

import java.math.BigDecimal;

/**
 * 有一个潘多拉盒子，每次可以从里面掏出一个印有编号的球，盒子里装有无数个球，每次掏都会有，但是编号随机。已知编号共有1亿个，请问一般掏多少次，手里就几乎一定会有相同的球？
 *
 * 说明：几乎一定，指概率达到99.9%。
 */
public class Demo {
    public static void main(String[] args) {
        int all = 100_000_000;
        double rate = 1.0;
        for (int i = 0; i <= all; i++) {
            rate *= (double) (all - i) /all;
            if (rate < 0.001){
                System.out.println(i);
                break;
            }
        }
    }
}
