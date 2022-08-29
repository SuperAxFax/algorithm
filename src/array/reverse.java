package array;

import java.util.Arrays;

public class reverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        rev(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rev(int[] arr){
        int temp = 0;
        for (int i = 0,j = arr.length-1; i < j; i++,j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
