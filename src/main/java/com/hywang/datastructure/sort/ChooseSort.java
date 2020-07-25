package com.hywang.datastructure.sort;

/**
 * 选择排序
 */
public class ChooseSort {

    public static int[] sort(int[] arr) {

        int pos;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            pos = 0;
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] < arr[pos]){
                    pos =j;
                }
            }
            //交换
            temp =arr[pos];
            arr[pos] = arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return arr;
    }
}
