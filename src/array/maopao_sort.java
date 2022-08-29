package array;

import java.util.Arrays;

/**
 * 确定排序的次数与每次排序的个数即可
 */
public class maopao_sort {
    public static void main(String[] args) {
        int[] arr = {5,3,47,2,8,9,2};
        maopao_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

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
}
