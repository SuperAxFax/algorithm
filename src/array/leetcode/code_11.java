package array.leetcode;

/**
 * 盛最多水的容器
 *
 * 思考：首先直接暴力求解每个数组之间进行组合，找到最大的那个值即可
 */
public class code_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
        int plus = maxAreaPlus(height);
        System.out.println(plus);
    }

    /**
     * 解法一：时间复杂度为O(n^2)
     * 主要思想是暴力循环比较
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0, mid;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j< height.length; j++ ){
                if (height[i]>height[j]){
                    mid = height[j]*(j-i);
                }else if (height[i]==j){
                    mid = height[i]*(j-i);
                }else {
                    mid = height[i]*(j-i);
                }
                if (mid > max){
                    max = mid;
                }
            }
        }
        return max;
    }

    /**
     * 解法二：时间复杂度为O(n)
     * 主要思想是使用贪心的思想，从两边向中间靠拢，不断寻找最大值。
     * @param height
     * @return
     */
    public static int maxAreaPlus(int[] height){
        int left = 0, right = height.length-1;
        int max = 0,count = 0;
        while (left<right){
            if (height[left] <= height[right]){
                count = height[left]*(right-left);
                max = Math.max(count,max);
                ++left;
            }else {
                count = height[right]*(right-left);
                max = Math.max(count,max);
                --right;
            }
        }
        return max;
    }
}
