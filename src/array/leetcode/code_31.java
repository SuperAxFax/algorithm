package array.leetcode;

import java.util.Arrays;

/**
 * 移除元素
 */
public class code_31 {
    /**
     * 思考步骤：首先有比当前数组大的就输出接下来的那个，如果此时是最大的那就输出最小值的数组。由于数组中
     * 的元素大于等于0.第一步肯定还是先排序，在进行比较。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3};
    }
    public void nextPermutation(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        }
    }

}
