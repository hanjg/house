package com.babyjuan.house.task.spider;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @Author: hjg
 * @Date: Create in // :
 * @Description:
 */
public class CountDownLatchTest {

    @Test
    public void work() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker("zhangsan", 1000, latch);
        Worker worker2 = new Worker("lisi", 2000, latch);
        Worker worker3 = new Worker("wangwu", 5000, latch);
        worker1.start();
        worker2.start();
        worker3.start();
        latch.await(); // 等待所有工人完成工作
        System.out.println("all work done at " + new Date());
    }

    @Test
    public void command() {
        //创建一个线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //指挥官的命令，设置为1，指挥官一下达命令，则cutDown,变为0，战士们执行任务
        final CountDownLatch cdOrder = new CountDownLatch(1);
        //因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，当三个都执行完毕，变为0，则指挥官停止等待。
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "正准备接受命令");
                        //战士们都处于等待命令状态
                        cdOrder.await();
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "已接受命令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "回应命令处理结果");
                        //任务执行完毕，返回给指挥官，cdAnswer减1。
                        cdAnswer.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);//为线程池添加任务
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));

            System.out.println("线程" + Thread.currentThread().getName() +
                    "即将发布命令");
            cdOrder.countDown(); //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已发送命令，正在等待结果");
            cdAnswer.await(); //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已收到所有响应结果");
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown(); //任务结束，停止线程池的所有线程

    }
}

class Worker extends Thread {

    String workerName;
    int workerTime;
    CountDownLatch latch;

    public Worker(String workerName, int workerTime, CountDownLatch latch) {
        this.workerName = workerName;
        this.workerTime = workerTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("worker " + workerName + " do work begin at " + new Date());
        doWork(); // 工作了
        System.out.println("woker " + workerName + " do work end at " + new Date());
        latch.countDown();//工人完成工作，计数器减一
    }

    private void doWork() {
        try {
            Thread.sleep(workerTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
