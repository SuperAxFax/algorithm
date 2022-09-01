package array.leetcode;

/**
 * 删除有序数组中的重复项
 */
public class code_26 {
    /**
     * 思考过程：由于不让开辟新的空间，并且只允许额外的空间为O(1)，那么可以在判断到有重复元素的时候直接赋值到相应的位置
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    /**
     * 经过查看题解真是绝了，真的是巧妙的思想。使用双指针解法。一个指针在家等着，另外一个则外出打拼，打拼的那个找到新物件了
     * 就通知家里面存起来，同时家里面的向前走一步。最后外出的探索完之后，家里面剩下的长度就是所赚到的财产。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
          int L = 0, R = 1;
          while(R < nums.length){
              if (nums[L] != nums[R]){
                  nums[L+1] = nums[R];
                  L++;
              }
              R++;
          }
          return L+1;
    }
}
