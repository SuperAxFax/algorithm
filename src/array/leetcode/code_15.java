package array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 思考过程：首先思考三个数之和为0一共有多少种情况。
 * 1：一个数为0，另外两个互为相反数
 * 2：一个数与另外两个的相反数之和相等
 * 经过查阅被人代码发现更好的思路应该是：先对数组进行排序，排序后先剔除重复元素的风险。然后从左往右依次
 * 进行求sum。对于满足条件的三个数放到List列表中去。
 */

/**
 * 小细节：
 * 1：数组中的排序直接使用Arrays.sort()
 * 2：List<List<Integer>>列表的使用。列表中存放列表。
 * 3：将数组元素转换成列表元素并插入列表：list.add(Arrays.aList(num[1],num[2],num[3]));
 */
public class code_15 {
    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(num);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i-1] == nums[i]) continue;
            int L = i+1;
            int R = nums.length-1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }else if (sum > 0){
                    R--;
                }else {
                    L++;
                }

            }
        }
        return list;
    }
}
