package array;

import java.util.Arrays;

public class binary_conversion {
    public static void main(String[] args) {
        String s = binary_conversion(15, 8);
        System.out.println(s);
    }

    /**
     * 十进制转换为其他进制
     * @param binary_pre
     * @param binary_aft
     * @return
     */
    public static String binary_conversion(int binary_pre, int binary_aft){
        StringBuffer stringBuffer = new StringBuffer();
        while (binary_pre != 0) {
            int yushu = binary_pre % binary_aft;
            char c = digital.chs[yushu];
            stringBuffer.insert(0,c);
            binary_pre = binary_pre/binary_aft;
        }
        return stringBuffer.toString();
    }
}
