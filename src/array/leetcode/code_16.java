package array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *思考过程：先将所有三个数之和都求出来放到一个list列表中，接着将目标值与该数组的所有数相加再取绝对值。最后
 * 进行排序，选取最小的那个值对应的数即可。
 * 出现的问题：在数据存为list列表类型
 */

/**
 * 小细节：
 * 三数之和和最接近三数之和使用的思想都是从左往右依次扫描。三数之和只需要从左往右扫描一次即可。但是最接近三数之和需要
 * 从左往右扫描n-2次。
 */
public class code_16 {
    public static void main(String[] args) {
        int [] arr = {1,1,1,0};
        int i = threeSumClosest1(arr, 1);
        System.out.println(i);
    }

    /**
     * 该方法使用的思想就是上面的思想，但是提交之后161个示例只有13个满足，显然还达不到要求
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int z = j+1; z < nums.length; z++) {
                    sum = nums[i] + nums[j] +nums[z];
                    list.add(sum);
                }
            }
        }
        int min =0,value = 0;
        for (int i = 0; i < list.size(); i++) {
            int abs = Math.abs(list.get(i) - target);
            if (abs < min){
                min = abs;
                value = i;
            }
        }
        return list.get(value);
    }

    /**
     * 使用从左到右依次扫描的思想，161/161
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1, R = nums.length - 1;
            while (L < R){
                int sum = nums[L] +nums[i] +nums[R];
                if (Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if (sum > target){
                    R--;
                }else if (sum < target){
                    L++;
                }else {
                    return target;
                }
            }
        }
        return ans;
    }

}
