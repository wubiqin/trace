package com.wbq.log.trace.btrace;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author: biqin.wu
 * @Date: 2019/5/20
 */
public class BtraceDemo {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start -----");

        new Thread(() -> {
            while (true) {
                BtraceDemo b = new BtraceDemo();
                System.out.println(b.cal(ThreadLocalRandom.current().nextInt()));
                try {
                    b.exception();
                } catch (Exception e) {

                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public int cal(Integer arg) {
        int res = 0;
        for (int i = 0; i < 20; i++) {
            res += arg;
        }
        return res;
    }

    public void exception() throws Exception {
        throw new NullPointerException();

    }
}
