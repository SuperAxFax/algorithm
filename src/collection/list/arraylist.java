package collection.list;

import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        /*装箱拆箱演示
        Integer sum = 0;
        for(int i=1000; i<5000; i++){ sum+=i; }*/


        /*ArrayList list = new ArrayList();*/
        ArrayList list = new ArrayList(8);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 10; i < 15; i++) {
            list.add(i);
        }
    }
}
