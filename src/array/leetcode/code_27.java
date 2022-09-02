package array.leetcode;

/**
 * 移除元素
 */
public class code_27 {
    /**
     * 思考过程，该题与上一个删除有序数组中的重复项很像，也可以使用双指针法
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int i = removeElement(arr,2);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
         int L = 0, R = 0;
         while (R < nums.length){
             if (nums[R] != val){
                 nums[L] = nums[R];
                 L++;
             }
             R++;
         }
         return L ;
    }
}
