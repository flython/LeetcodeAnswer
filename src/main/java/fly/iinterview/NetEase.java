package fly.iinterview;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目说明，模拟微信发红包，给定一个金额，给定一个人数，返回一个数组，该数组就是红包的金额
 *
 * 要求红包的钱数尽量平均
 *
 * 怎么让才能让红包尽量平均呢？
 */
public class NetEase {

    public String[] calculateTheRedEnvelope(String allMoney, int count){
        BigDecimal allCent = new BigDecimal(allMoney).multiply(new BigDecimal("100"));

        BigDecimal seed = new BigDecimal(3.0/count);
        BigDecimal d100 = new BigDecimal(100);

        LinkedList<String> resList = new LinkedList<>();

        for (int i = 0; i < count - 1; i++) {
            int thisCent = allCent.multiply(seed).intValue();
            int thisEnvelopeCent = (int) ((1 - Math.random()) * thisCent);
            thisEnvelopeCent = thisEnvelopeCent == 0? 1:thisEnvelopeCent;

            resList.add(new BigDecimal(thisEnvelopeCent).divide(d100).toString());
            allCent = allCent.subtract(new BigDecimal(thisEnvelopeCent));

        }

        resList.add(allCent.divide(d100).toString());

        return resList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] strings = new NetEase().calculateTheRedEnvelope("0.11", 10);
        System.out.println(Arrays.toString(strings));
    }

}
