package com.babyjuan.house.service.webmagic;

import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/11 22:42
 * @Description:
 */
public class ProxyPool implements ProxyProvider, Iterable<Proxy> {

    private Queue<Proxy> proxyQueue = new LinkedBlockingDeque<>();

    @Override
    public void returnProxy(Proxy proxy, Page page, Task task) {
        proxyQueue.add(proxy);
    }

    @Override
    public Proxy getProxy(Task task) {
        return proxyQueue.poll();
    }

    public boolean contain(Proxy proxy) {
        return proxyQueue.contains(proxy);
    }

    public void add(Proxy proxy) {
        proxyQueue.add(proxy);
    }

    @Override
    public Iterator iterator() {
        return proxyQueue.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        proxyQueue.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return proxyQueue.spliterator();
    }
}
