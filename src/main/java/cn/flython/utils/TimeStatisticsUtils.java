package cn.flython.utils;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
public class TimeStatisticsUtils {
    private static ThreadLocal<Long> start = new ThreadLocal<>();

    public static void nanoStart(){
        start.set(System.nanoTime());
    }

    public static void nanoEnd(){
        long time = System.nanoTime() - start.get();
        System.out.println();
        log.info("运行时间{}ns，大约为{}ms",time, time / 1000000);
    }
}
