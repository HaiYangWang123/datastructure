package com.hywang.sort;

/**
 * 冒泡排序
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        int[] arr = {78,89,67,98,90,56,88};
        int[] sort = sort(arr);
        for(int a:sort){
            System.out.print(a+" ");
        }
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j <  arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
