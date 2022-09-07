package collection.list;

import java.util.LinkedList;

public class linkedlist {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        /*使用迭代器循环遍历Linkedlist中元素的值。
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.printf("next值为："+next+"\n");
        }*/

        list.remove();
        System.out.println(list);


    }
}
