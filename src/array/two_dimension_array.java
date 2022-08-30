package array;

public class two_dimension_array {
    public static void main(String[] args) {
        //一：动态初始化
        //1：先初始化再赋值
        int[][] arr ;
        arr = new int[5][];
        arr[0] = new int[3];
        arr[1] = new int[1];
        arr[2] = new int[2];
        arr[3] = new int[4];
        arr[4] = new int[5];
        //2：初始化赋值一起
        int[][] arr1 = new int[5][2];

        //二：静态初始化
        //1：复杂版
        int[][] arr2 = new int[][]{{1,2,3},{3,4},{4,5,6,7}};
        //2：精简版
        int[][] arr3 = {{1,2},{3,4,5},{4,5,6,7}};


    }
}
