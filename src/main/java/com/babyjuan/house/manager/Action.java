package com.babyjuan.house.manager;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/10 20:20
 * @Description:
 */
public class Action {

    private CountDownLatch processLatch;

    /**
     * 等待动作的结束
     */
    public void await() throws InterruptedException {
        if (processLatch != null && processLatch.getCount() > 0) {
            return;
        }
        processLatch = new CountDownLatch(1);
        processLatch.await();
    }

    /**
     * 动作结束
     */
    public void countDown() {
        processLatch.countDown();
    }
}
