package array.leetcode;

import java.util.Arrays;

/**
 * 两数之和
 */
public class code_1 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j<nums.length; j++){
                if ((nums[i]+nums[j]) == target){
                    int[] arr1 = {i,j};
                    return arr1;
                }
            }
        }
        return null;
    }
}
