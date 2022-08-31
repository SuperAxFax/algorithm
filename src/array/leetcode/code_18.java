package array.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 四数之和
 */
public class code_18 {
    /**
     * 思考过程：四数之和和三数之和有什么不同：三数之和是三个数的和为0，四数之和要求的是四个数的和为0
     * @param args
     */

    /**
     * 小细节：
     * 1：当需要固定一个数就使用一个for,需要固定两个就使用两个for循环。当需要剩下的元素进行贪心查找时就使用while循环。
     * 2：当需要剔除相同元素时使用Set存储。返回的时候需要使用return new ArrayList<>(set);
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(arr, 0);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        long t = target;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 4)  return new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2 ;j++){
                int L = j+1; int  R =nums.length-1;
                while (L < R) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[L] + (long)nums[R];
                    if (sum == t) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;
                    } else if (sum > t) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
            return new ArrayList<>(set);
    }
}
