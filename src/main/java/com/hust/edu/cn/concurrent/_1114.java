package com.hust.edu.cn.concurrent;

import java.util.concurrent.CountDownLatch;

public class _1114 {
    private final CountDownLatch second = new CountDownLatch(1);
    private final CountDownLatch third = new CountDownLatch(1);

    public _1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // first最先运行
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // 通知second，first已运行完
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 调用second先等待，等待first运行完
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // 通知third，second已经运行完
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // 调用third先等待，等second运行完
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
