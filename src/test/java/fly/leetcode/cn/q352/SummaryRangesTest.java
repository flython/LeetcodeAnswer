package fly.leetcode.cn.q352;

import fly.leetcode.cn.q190.Solution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SummaryRangesTest {

    SummaryRanges sr = new SummaryRanges();

    @Test
    void getIntervals() {
        sr.addNum(64);
        print();
//        sr.addNum(128);
//        print();
//        sr.addNum(127);
//        print();
//        sr.addNum(46);
//        print();
//        sr.addNum(10000);
//        sr.addNum(10000-1);
//        sr.addNum(10000-2);
//        sr.addNum(0);
//        print();
    }

    private void print() {
        System.out.println(Arrays.stream(sr.getIntervals()).map(Arrays::toString).collect(Collectors.joining(",")));
    }
}