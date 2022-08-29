package array;

import java.util.Arrays;

public class binary_search {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,9,12,45,78};
        int i = binary_search(arr, 45);
        System.out.println(i);
    }

    /**
     * 先确定中间值，如果小于中间值则右边界减一；若大于中间值则左边界加一
     * @param arr
     * @return
     */
    public static int binary_search(int[] arr, int key){
        int left = 0, right = arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid] == key){
              return mid;
            }else if (key < arr[mid]){
                right = --mid;
            }else {
                left = ++mid;
            }
        }
        return -1;
    }
}
