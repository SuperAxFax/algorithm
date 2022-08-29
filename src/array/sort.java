package array;

import java.util.Arrays;

/**
 *
 */
public class sort {
    public static void main(String[] args) {
        int[] arr = {102,5,3,47,2,8,9,21,34,98};
        maopao_sort(arr);
        System.out.println(Arrays.toString(arr));
        xuanze_sort(arr);
        System.out.println("选择排序结果："+ Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 确定排序的次数与每次排序的个数即可
     * @param arr
     */
    public static void maopao_sort(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 每次从后面所有元素中选择一个最小的与标记的元素进行交换
     * @param arr
     */
    public static void xuanze_sort(int[] arr){
        int temp = 0;
        for (int i = 0 ; i< arr.length-1; i++){
            int temp_index = i;
            for (int j = i+1; j< arr.length-1; j++){
                if (arr[j]<arr[temp_index]){
                    temp_index = j;
                }
            }
            if (temp_index!= i){
                temp = arr[temp_index];
                arr[temp_index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
