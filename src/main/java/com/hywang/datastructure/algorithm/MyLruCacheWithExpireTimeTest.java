package com.hywang.datastructure.algorithm;


public class MyLruCacheWithExpireTimeTest<K, V> {
    public static void main(String[] args) throws InterruptedException {
        MyLruCacheWithExpireTime<Integer,String> myLruCache = new MyLruCacheWithExpireTime<>(3);
        myLruCache.put(1,"Java",3);
        myLruCache.put(2,"C++",3);
        myLruCache.put(3,"Python",1500);
        System.out.println(myLruCache.size());//3
        Thread.sleep(2);
        System.out.println(myLruCache.size());//2
    }
}

