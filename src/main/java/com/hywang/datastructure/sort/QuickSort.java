package com.hywang.datastructure.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public  void sort(int[] arr,int L,int R) {
        int i =L;
        int j = R;
        //支点
        int pivot = arr[(L+R)/2];
        // 左右两端进行扫描，只要两端还没交替，久一只扫描
        while (i<j){
            //寻找直到比支点大的数
            while (pivot > arr[i]){
             i++;
            }
            while (pivot <arr[j]){
                j--;
            }
            //此时已经分别找到了比支点肖的数（右边）   比支点大的数（左边） 他们进行交换
            if(i<=j){
                int temp  = arr[i];
                arr[i] = arr[j];
                arr[j]  =temp;
                i++;
            }
        }
    }
}