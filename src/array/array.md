1：数组的初始化

数组的初始化分为静态初始化与动态初始化；

动态初始化形式：

```java
int[] arr1 = new int[5];
```

静态初始化形式：

```java
int[] arr2 = new int[]{1,2,3,4,5};
或者
int[] arr3 = {1,2,3,4,5};
```
2：数组循环

分为普通for循环和增强for循环

增强for循环：

```java
int[] arr1 = {1,2,3,4,5,6,7,8,9};
for(int temp : arr1){
    System.out.println(temp);
}//里面的temp表示暂存数组中的每一个元素
```

-------------------------------------------------------------------------------------数组从后往前的遍历：

```java
int[] arr = {1,2,3,4,5,6,7,8,9};
for(int i=arr.length-1; i>=0; i--){
    System.out.println(arr[i]);
}
```

数组从两端向中间遍历：

```java
int[] arr = {1,2,3,4,5,6,7,8,9};
for(int i=0,j=arr.length-1; i<=j; i++,j--){
    System.out.println(arr[i]);
    System.out.println(arr[j]);
}
```

数组从中间向两端遍历：

```java
//核心要点，数组遍历是从0开始的
int[] arr1 = {1,2,3,4,5,6,7,8};
int[] arr2 = {1,2,3,4,5,6,7,8,9};
int i = arr1.length/2;
int j =0;
if(arr1.length%2 == 0){
    j = i-1;
}else{
    j = i;
}
for(;i>=0 && j<=arr1.length-1; j--,i++){
    if(i == j){
        System.out.println(arr1[i]);
    }else{
        System.out.println(arr1[i]);
        System.out.println(arr1[j]);
    }
}
```

数组从指定位置出发，从左到右依次环形遍历：

```java
//核心要点：使用取余操作进行循环遍历
int[] arr1 = {1,2,3,4,5,6,7,8,9};
int point = 3;
for(int start = point; (start+1)%arr1.length!=point;(++start)%arr1.length){
    System.out.println(arr1[start])
}
System.out.println(arr1[point]);
```




