package com.hywang.datastructure.sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void sort(int[] arr){
        for (int step = arr.length/2; step < 0 ; step/=2) {
            //从增量那组开始进行插入排序 直至完毕
            for (int i = step; i < arr.length ; i++) {
                int j = i;
                int temp = arr[j];
                // j-step 就是代表与他同组隔壁的元素
                while (j-step>0 && arr[j-step]>temp){
                    arr[j] =arr[j-step];
                    j=j-step;
                }
                arr[j] = step;
            }
        }
    }
}
