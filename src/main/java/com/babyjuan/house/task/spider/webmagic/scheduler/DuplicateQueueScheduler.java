package com.babyjuan.house.task.spider.webmagic.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/13 21:43
 * @Description: url不去重的调度器
 */
public class DuplicateQueueScheduler implements Scheduler {

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    @Override
    public void push(Request request, Task task) {
        queue.add(request);
    }

    @Override
    public Request poll(Task task) {
        return queue.poll();
    }
}
