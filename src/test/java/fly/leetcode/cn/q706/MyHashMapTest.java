package fly.leetcode.cn.q706;


import org.junit.jupiter.api.Test;

import java.util.Random;

public class MyHashMapTest {

    MyHashMap h = new MyHashMap();

    @Test
    public void test2(){
        Random random = new Random();
        int maxKey = Double.valueOf(Math.pow(10,6)).intValue();
        int times = Double.valueOf(Math.pow(10,4)).intValue() * 3;
        for (int i = 0; i < maxKey; i++){
            int key = random.nextInt(maxKey+1);
            switch (random.nextInt(3)){
                case 0:
                    h.put(key, random.nextInt(maxKey));
                    break;
                case 1:
                    h.get(key);
                    break;
                case 2:
                    h.remove(key);
                    break;
            }
        }
        System.out.printf("stop");
    }

    @Test
    public void put2() {
        h.remove(27);
        h.put(65,65);
        h.remove(19);
        h.remove(0);
        h.get(18);
        h.remove(3);
        h.put(42,0);
        h.get(19);
        h.remove(42);
        h.put(17,90);
        h.put(31,76);
        h.put(48,71);
        h.put(5,50);
        h.put(7,68);
        h.put(73,74);
        h.put(85,18);
        h.put(74,95);
        h.put(84,82);
        h.put(59,29);
        h.put(71,71);
        h.remove(42);
        h.put(51,40);
        h.put(33,76);
        h.get(17);
        h.put(89,95);
        h.get(95);
        h.put(30,31);
        h.put(37,99);
        h.get(51);
        h.put(95,35);
        h.remove(65);
        h.remove(81);
        h.put(61,46);
        h.put(50,33);
        h.get(59);
        h.remove(5);
        h.put(75,89);
        h.put(80,17);
        h.put(35,94);
        h.get(80);
        h.put(19,68);
        h.put(13,17);
        h.remove(70);
        h.put(28,35);
        h.remove(99);
        h.remove(37);
        h.remove(13);
        h.put(90,83);
        h.remove(41);
        h.get(50);
        h.put(29,98);
        h.put(54,72);
        h.put(6,8);
        h.put(51,88);
        h.remove(13);
        h.put(8,22);
        h.get(85);
        h.put(31,22);
        h.put(60,9);
        h.get(96);
        h.put(6,35);
        h.remove(54);
        h.get(15);
        h.get(28);
        h.remove(51);
        h.put(80,69);
        h.put(58,92);
        h.put(13,12);
        h.put(91,56);
        h.put(83,52);
        h.put(8,48);
        h.get(62);
        h.get(54);
        h.remove(25);
        h.put(36,4);
        h.put(67,68);
        h.put(83,36);
        h.put(47,58);
        h.get(82);
        h.remove(36);
        h.put(30,85);
        h.put(33,87);
        h.put(42,18);
        h.put(68,83);
        h.put(50,53);
        h.put(32,78);
        h.put(48,90);
        h.put(97,95);
        h.put(13,8);
        h.put(15,7);
        h.remove(5);
        h.remove(42);
        h.get(20);
        h.remove(65);
        h.put(57,9);
        h.put(2,41);
        h.remove(6);
        h.get(33);
        h.put(16,44);
        h.put(95,30);

    }
}