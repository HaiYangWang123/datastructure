package com.hywang.datastructure.sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static int[] sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            //如果前一位（已排序的数组）比当前数据要大，那么久进入循环比较
            int j = i-1;
            while(j>=0 && arr[j] >temp){
               //往后退一个位置  让当前数据与之前前位进行比较
                arr[j+1] = arr[j];
                //不断往前 直至退出
                j--;
            }
            //退出循环 说明找到了合适的位置 ，将当前数据插入合适的位置中
            arr[j+1 ] =temp;
        }
        return arr;
    }
}
