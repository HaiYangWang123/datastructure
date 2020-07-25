package com.hywang.datastructure.algorithm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyLruTest {

    public static void main(String[] args) throws InterruptedException {
        /*MyLru<Integer, String> myLruCache = new MyLru<>(3);
        myLruCache.put(1, "Java");
        System.out.println(myLruCache.get(1));// Java
        myLruCache.remove(1);
        System.out.println(myLruCache.get(1));// null
        myLruCache.put(2, "C++");
        myLruCache.put(3, "Python");
        System.out.println(myLruCache.get(2));//C++
        myLruCache.put(4, "C");
        myLruCache.put(5, "PHP");
        System.out.println(myLruCache.get(2));// C++
*/

        int threadNum = 10;
        int batchSize = 10;
//init cache
        MyLru<String, Integer> myLruCache = new MyLru<>(batchSize * 10);
//init thread pool with 10 threads
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(threadNum);
//init CountDownLatch with 10 count
        CountDownLatch latch = new CountDownLatch(threadNum);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        for (int t = 0; t < threadNum; t++) {
            fixedThreadPool.submit(() -> {
                for (int i = 0; i < batchSize; i++) {
                    int value = atomicInteger.incrementAndGet();
                    myLruCache.put("id" + value, value);
                }
                latch.countDown();
            });
        }
        //wait for 10 threads to complete the task
        latch.await();
        fixedThreadPool.shutdown();
        System.out.println("Cache size:" + myLruCache.size());//Cache size:100
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(String.format("Time cost：%dms", duration));//Time cost：511ms
    }
}
